package com.husheng.youxi.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

	// md5加密
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}

	// 密码加盐处理
	public static final String salt = "itbooking.123sk";

	public static String inputPassToFormPass(String inputPass) {
		// 混淆视听 slat
		String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
		// 加密一次
		return md5(str);
	}

	// inputPassToFormPass + formPassToDBPass = inputPassToDbPass(数据的最终密码)
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);// 11dad9c3d844b8f7eac85c9e4e6de267
		String dbPass = formPassToDBPass(formPass, saltDB);// 把混淆加密的密码在进行一次加密
		return dbPass;
	}
	
	public static String inputPassToDbPass(String inputPass) {
		String formPass = inputPassToFormPass(inputPass);// 11dad9c3d844b8f7eac85c9e4e6de267
		String dbPass = formPassToDBPass(formPass, salt);// 把混淆加密的密码在进行一次加密
		return dbPass;
	}

	/**
	 * 
	 * @param formPass
	 * @param salt
	 * @return
	 */
	public static String formPassToDBPass(String formPass, String salt) {
		String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}

	public static void main(String[] args) {
		System.out.println(md5(salt + "123456"));
		System.out.println(inputPassToFormPass("123456"));// 11dad9c3d844b8f7eac85c9e4e6de267
		System.out.println(formPassToDBPass(inputPassToFormPass("mkxiaoer19860207"), salt));
		System.out.println(inputPassToDbPass("123456"));// b7797cce01b4b131b433b6acf4add449
	}
}
