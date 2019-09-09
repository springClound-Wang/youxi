package com.husheng.youxi.core;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shiqm on 2017/3/14.
 */
public class RequestUtil {

	public static String getRequestIP(HttpServletRequest request) {
		String clientIp = request.getHeader("x-forwarded-for");
		if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
			clientIp = request.getHeader("Proxy-Client-IP");
		}
		if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
			clientIp = request.getHeader("WL-Proxy-Client-IP");
		}
		if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
			clientIp = request.getRemoteAddr();
		}
		return clientIp;
	}

	public static boolean isResponseBody(HttpServletRequest request) {
		if (request.getRequestURI().indexOf("ajax") > -1) {
			return true;
		}
		return false;
	}

	/**
	 * 得到请求的根目录
	 *
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath  = null;
		if(request.getServerPort()==80) {
			basePath =   "http://" + request.getServerName() + path;
		}else {
			basePath =  "http://" + request.getServerName() + ":" + request.getServerPort() + path;
		}
		return basePath;
	}

	/**
	 * 得到结构目录
	 *
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {
		String path = request.getContextPath();
		return path;
	}

}
