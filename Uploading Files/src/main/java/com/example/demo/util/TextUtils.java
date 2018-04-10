/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.util;

/**
 * <p>
 * <code>TextUtils</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/10 15:54
 */
public class TextUtils {

	/**
	 * 字符串转Unicode
	 * @param text 文本
	 * @return unicode编码
	 */
	public static String stringToUnicode( String text ){
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}
}
