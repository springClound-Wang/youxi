package com.husheng.youxi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.husheng.youxi.core.Params;
import com.husheng.youxi.pojo.userClient;

/**
 * 
 * todo:C端用户管理模块数据层
 * userClientMapper<br/>
 * 创建人:汪正章<br/>
 * 时间：2019年09月09日 22:37:33 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface userClientMapper {

	//添加
	public int saveuserClient(userClient userclient);
	//修改
	public int updateuserClient(userClient userclient);
	//删除
	public int deleteuserClientById(@Param("id")Integer id);
	//查询单个
	public userClient getuserClientById(@Param("id")Integer id);
	//查询所有
	public List<userClient> queryuserClientAll(Params params);
	// 查询所有
	public List<Map<String,Object>> queryuserClientAllForMap(Params params);
	//查询单个
	public Map<String,Object> getuserClientByIdForMap(@Param("id")Integer id);
	//删除多个
	public int deleteuserClientByIds(@Param("opids")List<Integer> idIntegers);

}