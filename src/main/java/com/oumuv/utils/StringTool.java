package com.oumuv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTool {


	/**
	 * 字符串截取，指定位置截取到字符末尾
	 * @param regex 开始截取的位置的字符
	 * @param str
	 */
	public final static String subStringIndex2End(String regex,String str){
		String substring = "";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        if(matcher.find()){
//        	System.out.println("匹配字符："+matcher.start());
			substring += str.substring(matcher.start(), str.length());
//        	System.out.println(substring);
        }
		return substring;
	}
}
