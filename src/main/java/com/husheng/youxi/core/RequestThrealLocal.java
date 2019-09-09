//
// /**
// * itbooking系统平台<br/>
// * com.itbooking.vo<br/>
// * RequestThrealLocalUtil.java<br/>
// * 创建人:mofeng <br/>
// * 时间：2018年9月27日-下午8:30:50 <br/>
// * 2018itbooking-版权所有<br/>
// */
//package com.itbooking.core;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.itbooking.pojo.AdminUser;
//
///**
// * 
// * RequestThrealLocalUtil<br/>
// * 创建人:mofeng<br/>
// * 时间：2018年9月27日-下午8:30:50 <br/>
// * @version 1.0.0<br/>
// * 
// */
//public class RequestThrealLocal {
//
//	//创建一个本地线程--当前线程的副本，存储用户信息
//	//什么是当前线程，两个请求算一个线程呢？还是两个线程
//	private static ThreadLocal<AdminUser> userLocals = new ThreadLocal<>();
//	private static ThreadLocal<HttpServletRequest> requestLocals = new ThreadLocal<>();
//	
//	//从本地线程中获取
//	public static AdminUser getUser() {
//		return userLocals.get();
//	}
//	
//	//放入到本地线程中
//	public static void addUser(AdminUser user) {
//		userLocals.set(user);
//	}
//	
//	public static void addRequest(HttpServletRequest request) {
//		requestLocals.set(request);
//    }
//
//    public static HttpServletRequest getCurrentRequest() {
//        return requestLocals.get();
//    }
//
//	
//	//删除
//	public static void del() {
//		userLocals.remove();
//		requestLocals.remove();
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
