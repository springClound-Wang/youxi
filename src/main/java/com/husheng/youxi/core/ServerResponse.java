package com.husheng.youxi.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by mofeng
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class ServerResponse implements Serializable {

	private int status;
	private String msg;
	private Object data;
	private String field;

	private ServerResponse(int status) {
		this.status = status;
	}

	private ServerResponse(int status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	private ServerResponse(int status,String filed, String msg) {
		this.status = status;
		this.field = filed;
		this.msg = msg;
	}

	private ServerResponse(int status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	private ServerResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

/*	@JsonIgnore
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}
*/
	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}

	public String getField() {
		return field;
	}

	public static  ServerResponse createBySuccess() {
		return new ServerResponse(ResponseCode.SUCCESS.getCode());
	}

	public static  ServerResponse createBySuccessMessage(String msg) {
		return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static  ServerResponse createBySuccess(Object data) {
		return new ServerResponse(ResponseCode.SUCCESS.getCode(), data);
	}

	public static  ServerResponse createBySuccess(String msg, Object data) {
		return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	public static  ServerResponse createBySuccess(Integer status,String msg, Object data) {
		return new ServerResponse(status, msg, data);
	}

	public static  ServerResponse createByError() {
		return new ServerResponse(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}


	public static  ServerResponse createByErrorMessage(ResponseCode responseCode) {
		return new ServerResponse(responseCode.getCode(), responseCode.getDesc());
	}
	
	public static  ServerResponse createByErrorMessage(ResponseCode responseCode,Object data) {
		return new ServerResponse(responseCode.getCode(), responseCode.getDesc(),data);
	}

	
	public static  ServerResponse createByErrorMessage(String errorMessage) {
		return new ServerResponse(ResponseCode.ERROR.getCode(), errorMessage);
	}
	
	public static  ServerResponse createByValidatorError(String filed,String errorMessasge) {
		return new ServerResponse(405,filed,errorMessasge);
	}
	

	public static  ServerResponse createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ServerResponse(errorCode, errorMessage);
	}
	
	public static  ServerResponse createByErrorCodeMessage(int errorCode,String filed, String errorMessage) {
		return new ServerResponse(errorCode,filed,errorMessage);
	}
	
	
	/**
	 *  转化
	 *  方法名：toMap<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月18日-下午3:05:17 <br/>
	 * 手机:1564545646464<br/>
	 * @return Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public  Map<String, Object> toMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("status", status);
		map.put("msg",msg);
		map.put("data",data);
		return map;
	}

}