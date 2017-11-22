package com.oumuv.utils;

public class StringTool {

	/**
	 * 如果对象是空则返回true
	 * @param o
	 * @return
	 */
	private static boolean isEmpty(Object o){
		//if 'object' is NULL or the String length is 0 retrun true
		if(null==o&&o.toString().equals("")){
			return true;
		}
		return false;
	}
}
