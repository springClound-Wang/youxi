package com.husheng.youxi.service.userclient;

import com.husheng.youxi.pojo.userClient;
import com.husheng.youxi.core.ServerResponse;


/**
*
* todo:C端用户管理模块业务接口
* userClientService<br/>
* 创建人:汪正章<br/>
* 时间：2019年09月09日 22:37:33 <br/>
* @version 1.0.0<br/>
*
*/
public interface IuserClientService {
	
	/**
	 * 
	 *  保存C端用户管理模块
	 * 方法名：saveuserClient<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param userclient
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse saveuserClient(userClient userclient);
	
	/**
	 * 
	 * (修改C端用户管理模块)<br/>
	 * 方法名：updateuserClient<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:1564545646464<br/>
	 * @param userclient
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse updateuserClient(userClient userclient);
	
	/**
	 * 
	 * (根据id删除C端用户管理模块)<br/>
	 * 方法名：deleteuserClientById<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse deleteuserClientById(Integer id);
	
	/**
	 * 
	 * (根据id获取C端用户管理模块)<br/>
	 * 方法名：getuserClientById<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse getuserClientById(Integer id);
	
	/**
	 * 
	 * (查询所有的C端用户管理模块)<br/>
	 * 方法名：queryuserClientAll<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:1564545646464<br/>
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryuserClientAll(String keyword,int pageNo,int pageSize);

	/**
	*
	* 批量删除<br/>
	* 方法名：deleteuserClientByIds<br/>
	* 创建人：汪正章 <br/>
	* 时间：2019年09月09日 22:37:33 <br/>
	* 手机:1564545646464<br/>
	* @return ServerResponse<br/>
	* @exception <br/>
	* @since  1.0.0<br/>
	*/
	public ServerResponse deleteuserClientByIds(String opids);

	/**
	*
	* (查询所有的C端用户管理模块)<br/>
	* 方法名：queryuserClientAllForMap<br/>
	* 创建人：汪正章 <br/>
	* 时间：2019年09月09日 22:37:33 <br/>
	* 手机:1564545646464<br/>
	* @return ServerResponse<br/>
	* @exception <br/>
	* @since  1.0.0<br/>
	*/
	public ServerResponse queryuserClientAllForMap(String keyword,int pageNo,int pageSize);

	/**
	*
	* (查询单个的C端用户管理模块)<br/>
	* 方法名：getuserClientByIdForMap<br/>
	* 创建人：汪正章 <br/>
	* 时间：2019年09月09日 22:37:33 <br/>
	* 手机:1564545646464<br/>
	* @return ServerResponse<br/>
	* @exception <br/>
	* @since  1.0.0<br/>
	*/
	public ServerResponse getuserClientByIdForMap(Integer id);
}
