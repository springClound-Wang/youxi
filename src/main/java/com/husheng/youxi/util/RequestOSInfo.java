
 /**
 * itbooking系统平台<br/>
 * com.itbooking.util<br/>
 * RequestOSInfo.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年10月1日-上午1:49:12 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.husheng.youxi.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * RequestOSInfo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年10月1日-上午1:49:12 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class RequestOSInfo {

	/**
     * 获取操作系统,浏览器及浏览器版本信息
     * @param request
     * @return
     */
    public static String getOsAndBrowserInfo(HttpServletRequest request){
        String  browserDetails  =   request.getHeader("User-Agent");
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();
 
        String os = "";
        String browser = "";
 
        //=================OS Info=======================
        if (userAgent.toLowerCase().indexOf("windows") >= 0 )
        {
            os = "Windows";
        } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
        {
            os = "Mac";
        } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
        {
            os = "Unix";
        } else if(userAgent.toLowerCase().indexOf("android") >= 0)
        {
            os = "Android";
        } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
        {
            os = "IPhone";
        }else{
            os = "UnKnown, More-Info: "+userAgent;
        }
        //===============Browser===========================
        if (user.contains("edge"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
        } else if (user.contains("msie"))
        {
            //String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            //browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
            browser="MSIE";
        } else if (user.contains("safari") && user.contains("version"))
        {
            //browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+ "-" +(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        	browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0];
        } else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("opera")){
                //browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            	browser="Opera";
            }else if(user.contains("opr")){
                //browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
                browser="OPR";
            }
 
        } else if (user.contains("chrome"))
        {
            //browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        	browser="Chrome";
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  ||
                (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||
                (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            browser = "Netscape";
 
        } else if (user.contains("firefox"))
        {
           // browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
            browser="Firefox";
        } else if(user.contains("rv"))
        {
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
            browser="IE" + IEVersion.substring(0,IEVersion.length() - 1);
        } else
        {
            browser = "UnKnown";
        }
 
        return os +"_"+ browser ;
    }

}
