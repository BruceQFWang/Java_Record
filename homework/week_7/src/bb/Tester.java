package bb;

import java.util.regex.*;   
public class Tester {       
	public static void main (String[] args) {           
		String str = "cyberdebut@gmail.com15528330350@qq.com";         
		String reg = "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})";          
		Pattern pattern = Pattern.compile (reg);         
		Matcher matcher = pattern.matcher (str);   
		System.out.println ("输出所有的email地址：");
		while (matcher.find()) {  System.out.println (matcher.group()); } 
	}
}




