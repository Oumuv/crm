package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRunClass {
	
	@Test
	public void run(){
		List<Long> l1 = new ArrayList<Long>();
		List<Long> l2 = new ArrayList<Long>();
//		l1.add(1L);
		l1.add(2L);
		l1.add(3L);
//		l1.add(4L);
//		l1.add(5L);
		
//		l2.add(4L);
//		l2.add(5L);
//		l2.add(6L);
		l2.add(2L);
		l2.add(8L);
		
		List<Long> del = setDifferenceSet(l1,l2);
		List<Long> add = setDifferenceSet(l2,l1);
		int i=0;
		
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
