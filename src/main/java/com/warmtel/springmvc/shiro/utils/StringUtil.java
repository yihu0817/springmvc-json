package com.warmtel.springmvc.shiro.utils;

public class StringUtil {
	public static boolean isNullOrBlank(String str) {
		return (str == null) || (str.trim().length() < 1);
	}
}
