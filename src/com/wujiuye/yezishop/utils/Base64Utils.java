package com.wujiuye.yezishop.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * base64编码解码工具
 * @author wjy
 *
 */
public final class Base64Utils {

	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(String msg) {
		byte[] bstr;
		try {
			bstr = msg.getBytes("utf-8");
			return new sun.misc.BASE64Encoder().encode(bstr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static String decode(String str) {
		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
			String msg = new String(bt,"utf-8");
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
