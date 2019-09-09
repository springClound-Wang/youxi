package com.husheng.youxi.core;

/**
 * Created by mofeng enum类 类---
 */
public enum SexEnum {

	MALE(1, "男"), WOMAN(0, "女");

	private final int code;
	private final String name;

	SexEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}