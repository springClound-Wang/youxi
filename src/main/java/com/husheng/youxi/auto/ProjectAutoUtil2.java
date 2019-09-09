
/**
 * husheng/youxi系统平台<br/>
 * com.husheng/youxi.util<br/>
 * ProjectAutoUtil.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月25日-下午10:21:55 <br/>
 * 2018husheng/youxi-版权所有<br/>
 */
package com.husheng.youxi.auto;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * 自动构建类
 * ProjectAutoUtil<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午10:21:55 <br/>
 *
 * @version 1.0.0<br />
 */
public class ProjectAutoUtil2 {
    //定义模块
    private static String beanModel = "userClient";//修改此处
    private static String tablename = "user_client";//修改此处数据表
    private static String model = beanModel.toLowerCase();
    private static String author = "汪正章";
    private static String description = "C端用户管理模块";
    private static String phone = "17601430479";
    private static String datetime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
    //获取当前项目路径
    private static String projectPath = System.getProperty("user.dir");


    public static Connection getMySQLConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://47.99.172.85:3306/youxi?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root", "123456");
        return connection;
    }

    public static List<Map<String, String>> loadTable() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getMySQLConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + tablename;
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            List<Map<String, String>> maps = new ArrayList<>();
            Map<String, String> columnCommentByTableName = getColumnCommentByTableName(tablename);
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String field = rsmd.getColumnName(i);
                int type = rsmd.getColumnType(i);
                String strtype = JDBCTypesUtils.jdbcTypeToJavaType(type).getName();
                Map<String, String> map = new HashMap<>();
                map.put("column", field);//数据库原有的名字
                map.put("name", Tool.lineToHump(field));//小写名字，
                map.put("hname", Tool.HlineToHump(field));//大写的名字，服务于set get
                map.put("type", strtype);//字段对应的java类型
                map.put("comment",columnCommentByTableName.get(field));
                map.put("dtype", JDBCTypesUtils.getJdbcName(type));//字段对应的java类型
                map.put("ctype", strtype.substring(strtype.lastIndexOf(".") + 1));//没有包的类型名字
                maps.add(map);
            }
            return maps;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)rs.close();
                if(stmt!=null)stmt.close();
                if(conn!=null)conn.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }


    /*
    获得某表中所有字段的注释
    * @param tableName
    * @return
            * @throws Exception
    */
    public static Map<String,String> getColumnCommentByTableName(String tableName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Map<String,String> map = new HashMap<>();
            conn = getMySQLConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("show full columns from " + tableName);
            System.out.println("【" + tableName + "】");
            while (rs.next()) {
                map.put(rs.getString("Field"), rs.getString("Comment"));
            }
            return map;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            try {
                if(rs!=null)rs.close();
                if(stmt!=null)stmt.close();
                if(conn!=null)conn.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    public static void loadTemplate(List<Map<String, String>> maps, String packagename, String filename, String template) {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            // 指定模板文件从何处加载的数据源，这里设置成一个文件目录。
            cfg.setDirectoryForTemplateLoading(new File(projectPath + "/templates"));
            // 指定模板如何检索数据模型，这是一个高级的主题了… // 但先可以这么来用：
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));

            // 创建根哈希表
            Map root = new HashMap();
            // 在根中放入字符串"user"
            root.put("tablename", tablename);
            root.put("author", author);
            root.put("beanModel", beanModel);
            root.put("model", model);
            root.put("phone", phone);
            root.put("basePath", "${basePath}");
            root.put("rootPath", "${rootPath}");
            root.put("datetime", datetime);
            root.put("description", description);
            root.put("fields", maps);
            root.put("kuohao", new AddKuohu());
            root.put("kuohao2", new AddKuohu2());
            root.put("kuohao3", new AddKuohu3());
            root.put("listtag", new ListTag());
            root.put("Include", new IncludeTagMethod());


            Template temp = cfg.getTemplate(template);
            File rootPath = new File(projectPath, packagename);
            if (!rootPath.exists()) rootPath.mkdirs();
            File pojo = new File(rootPath, filename);
            Writer out = new OutputStreamWriter(new FileOutputStream(pojo), "utf-8");
            temp.process(root, out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

        List<Map<String, String>> maps = loadTable();

		String pojo = "src/main/java/com/husheng/youxi/pojo";
		loadTemplate(maps,pojo,beanModel+".java","pojo.tml");

		String mapper = "src/main/java/com/husheng/youxi/mapper";
		loadTemplate(maps,mapper,beanModel+"Mapper.java","mapper.tml");

		String mapperxml = "src/main/resources/mappers";
		loadTemplate(maps,mapperxml,beanModel+"Mapper.xml","mapperxml.tml");

		//service
		String service = "src/main/java/com/husheng/youxi/service/"+model;
		loadTemplate(maps,service,"I"+beanModel+"Service.java","service.tml");

		//service impl
		String serviceimpl = "src/main/java/com/husheng/youxi/service/"+model;
		loadTemplate(maps,serviceimpl,beanModel+"ServiceImpl.java","serviceImpl.tml");

		//controller
		String controller = "src/main/java/com/husheng/youxi/controller/"+model;
		loadTemplate(maps,controller,beanModel+"Controller.java","controller.tml");
//
        //vo
        //String vo = "src/main/java/com/husheng/youxi/vo";
        //loadTemplate(maps,vo,beanModel+"Vo.java","vo.tml");


        //page
        //String pageindex = "src/main/resources/templates/"+model;
        //loadTemplate(maps,pageindex,"index.html","index.tml");

        //template
//		String template = "src/main/resources/templates/"+model;
//		loadTemplate(maps,template,"template.html","template.tml");
//		
        //tempjslate
        //String tempjslate = "src/main/resources/static/js/main/";
        //loadTemplate(maps,tempjslate,model+".js","js.tml");

        //listtag
        //String listtag = "src/main/java/com/husheng/youxi/tag/"+model;
        //loadTemplate(maps,listtag,beanModel+"ListTag.java","listtag.tml");

        //benatag
        //String benatag = "src/main/java/com/husheng/youxi/tag/"+model;
        //loadTemplate(maps,benatag,beanModel+"BeanTag.java","beantag.tml");

    }
}

//统计项目有多少个java,有多少个资源文件，
//如何自己去写自动构建
//maven插件来完成



