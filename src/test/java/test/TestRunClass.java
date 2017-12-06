package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRunClass {
	
	
	final static TestSynchronze testSynchronze = new  TestSynchronze();
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				testSynchronze.testrun(); 
				System.out.println(testSynchronze);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				testSynchronze.testrun();  
				System.out.println(testSynchronze);
			}
		});
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				new TestSynchronze().testrun();  
				System.out.println(testSynchronze);
			}
		});
		t1.start();
		t2.start();
		t3.start();	
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
