package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRunClass {
	
	
	public static void main(String[] args) {
	}
	public void run(){
			
	}
	
	/**
	 * 集合差集运算
	 * @return
	 */
	private List<Long> setDifferenceSet(List<Long> list1,List<Long> list2){
		List<Long> list = new ArrayList<Long>();
		 list.addAll(list1);
		list.removeAll(list2);
		return list;
	}
	
	
	
	
}
