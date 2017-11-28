package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRunClass {
	
	@Test
	public void run(){
		System.out.println("测试");
		String pattern = "/upload";
        Pattern compile = Pattern.compile(pattern);
        String path = "E:/apache-tomcat-7.0.82-windows-x64/apache-tomcat-7.0.82/webapps/mycrm/upload/2017/1127/20171127172446_20171031124322.png";
        Matcher matcher = compile.matcher(path);
        if(matcher.find()){
        	System.out.println("匹配字符："+matcher.start());
        	String substring = path.substring(matcher.start(), path.length());
        	System.out.println(substring);
        }else{
        	
        }
	}
}
