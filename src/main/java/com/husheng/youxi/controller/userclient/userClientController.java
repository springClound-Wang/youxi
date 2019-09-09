package com.husheng.youxi.controller.userclient;
import com.husheng.youxi.pojo.userClient;
import com.husheng.youxi.service.userclient.IuserClientService;
import com.husheng.youxi.core.ServerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * todo:C端用户管理模块Controller控制器类
 * userClientController<br/>
 * 作者:汪正章<br/>
 * 创建时间：2019年09月09日 22:37:33 <br/>
 * @version 1.0.0<br/>
 *
 */
@RestController
@Api(description = "C端用户管理模块",tags = "C端用户管理模块")
@RequestMapping("/api/userclient")
public class userClientController {
	
	@Autowired
	private IuserClientService userclientService;

	/**
	 * 查询C端用户管理模块信息并分页
	 * 方法名：getuserClient<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:17601430479<br/>
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	*/
	@GetMapping("/queryall")
	@ApiOperation(value="查询C端用户管理模块信息并分页", notes="查询C端用户管理模块信息并分页")
	public ServerResponse userclientqueryall(@RequestParam(value="pageNo",defaultValue="1",required=false) Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10",required=false) Integer pageSize,
			@RequestParam(value="keyword",defaultValue="",required=false) String keyword) {
		return userclientService.queryuserClientAllForMap(keyword,pageNo, pageSize);
	}
	
	/**
	 * 根据id查询信息
	 * 方法名：getuserClient<br/>
	 * 创建人汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:17601430479<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/get/{id}")
	@ApiOperation(value="根据ID获取C端用户管理模块", notes="根据ID获取C端用户管理模块")
	public ServerResponse getuserClient(@PathVariable("id") Integer id) {
		return userclientService.getuserClientByIdForMap(id);
	}

	/**
	 * 保存
	 * 方法名：saveuserClient<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33<br/>
	 * 手机:17601430479<br/>
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@PostMapping("/save")
	@ApiOperation(value="保存C端用户管理模块", notes="保存C端用户管理模块信息")
	public ServerResponse saveuserClient(@RequestBody userClient userclient) {
		return userclientService.saveuserClient(userclient);
	}
	
	/**
	 * 修改
	 * 方法名：updateuserClient<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:17601430479<br/>
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改C端用户管理模块", notes="修改C端用户管理模块")
	public ServerResponse updateuserClient(@RequestBody userClient userclient) {
		return userclientService.updateuserClient(userclient);
	}

	/**
	 * 删除
	 * 方法名：deleteuserClient<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:17601430479<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/delete/{id}")
	@ApiOperation(value="删除C端用户管理模块", notes="删除C端用户管理模块")
	public ServerResponse deleteuserClient(@PathVariable("id") Integer id) {
		return userclientService.deleteuserClientById(id);
	}

	/**
	 * 根据ids批量删除信息
	 * 方法名：deleteBatch<br/>
	 * 创建人：汪正章 <br/>
	 * 时间：2019年09月09日 22:37:33 <br/>
	 * 手机:17601430479<br/>
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	*/
	@GetMapping("/deleteBatch")
	@ApiOperation(value="批量删除C端用户管理模块", notes="批量删除C端用户管理模块")
	public ServerResponse deleteBatch(@RequestParam("opids") String opids) {
		return userclientService.deleteuserClientByIds(opids);
	}	
}