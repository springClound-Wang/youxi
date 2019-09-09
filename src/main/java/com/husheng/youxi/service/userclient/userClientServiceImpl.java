package com.husheng.youxi.service.userclient;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.husheng.youxi.mapper.userClientMapper;
import com.husheng.youxi.pojo.userClient;
import com.husheng.youxi.core.ServerResponse;
import com.husheng.youxi.core.Params;
import com.husheng.youxi.util.TmStringUtils;


/**
 * 
 * todo:C端用户管理模块Service实现类
 * userClientServiceImpl<br/>
 * 作者:汪正章<br/>
 * 创建时间：2019年09月09日 22:37:33 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class userClientServiceImpl implements IuserClientService  {

	@Autowired
	private userClientMapper userclientMapper;

	@Override
	public ServerResponse queryuserClientAll(String keyword,int pageNo,int pageSize){
		PageHelper.startPage(pageNo,pageSize);
		Params params = new Params();
		params.setIsDelete(0);
		params.setKeyword(keyword);
		List<userClient> userclients = userclientMapper.queryuserClientAll(params);
		PageInfo<userClient> pageInfo = new PageInfo<>(userclients);
		return ServerResponse.createBySuccess(pageInfo);
	}

	@Override
	public ServerResponse queryuserClientAllForMap(String keyword,int pageNo,int pageSize){
		PageHelper.startPage(pageNo,pageSize);
		Params params = new Params();
		params.setIsDelete(0);
		params.setKeyword(keyword);
		List<Map<String,Object>>  userclients = userclientMapper.queryuserClientAllForMap(params);
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(userclients);
		return ServerResponse.createBySuccess(pageInfo);
	}

	@Override
	public ServerResponse getuserClientById(Integer id) {
	userClient userclient = userclientMapper.getuserClientById(id);
	return userclient!=null?ServerResponse.createBySuccess(userclient):ServerResponse.createByError();
	}

	@Override
	public ServerResponse getuserClientByIdForMap(Integer id){
	Map<String,Object> userclient = userclientMapper.getuserClientByIdForMap(id);
	return userclient!=null?ServerResponse.createBySuccess(userclient):ServerResponse.createByError();
	}
	
	@Override
	public ServerResponse saveuserClient(userClient userclient) {
		// 名称
		userclient.setName(null);
		// 个性签名
		userclient.setSignature(null);
		//  性别 1男0女
		userclient.setSex(null);
		// 头像url
		userclient.setHeadImg(null);
		// 省份
		userclient.setProvince(null);
		// 城市
		userclient.setCity(null);
		// 作品表编号
		userclient.setWorksId(null);
		// 积分
		userclient.setIntegral(null);
		// 发布状态 0未发布 1发布
		userclient.setStatus(1);
		int count = userclientMapper.saveuserClient(userclient);
		return count>0?ServerResponse.createBySuccess(userclient):ServerResponse.createByError();
	}
	
	@Override
	public ServerResponse updateuserClient(userClient userclient) {
		int count = userclientMapper.updateuserClient(userclient);
		return count>0?ServerResponse.createBySuccess(userclient):ServerResponse.createByError();
	}

	@Override
	public ServerResponse deleteuserClientById(Integer id) {
		int count = userclientMapper.deleteuserClientById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	@Override
	public ServerResponse deleteuserClientByIds(String opids) {
		if(TmStringUtils.isEmpty(opids)){return ServerResponse.createByError();}
		String[] idStrings = opids.split(",");
		List<Integer> idIntegers = new ArrayList<Integer>();
		for (String string : idStrings) {
			idIntegers.add(Integer.parseInt(string));
		}
		int count = userclientMapper.deleteuserClientByIds(idIntegers);
		return count>0?ServerResponse.createBySuccess(count):ServerResponse.createByError();
	}
}
