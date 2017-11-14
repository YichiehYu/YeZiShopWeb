package com.wujiuye.yezishop.utils;

public class StringUtils {
	
	/**
	 * 判断字符串是否为空串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str==null||"".equals(str.trim());
	}

}
