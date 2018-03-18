package bb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Mobile{
	public static int matchesPhoneNumber(String phone_number) { 
		String cm = "^((13[4-9])|(147)|(15[0-2,7-9])|(17[8])|(18[2-4,7-8]))\\d{8}|(170[5])\\d{7}$"; 
		String cu = "^((13[0-2])|(145)|(15[5-6])|(17[156])|(18[5,6]))\\d{8}|(170[4,7-9])\\d{7}$"; 
		String ct = "^((133)|(149)|(153)|(17[3,7])|(18[0,1,9]))\\d{8}|(170[0-2])\\d{7}$"; 
		int flag = 0;
		if (phone_number.matches(cm)) { 
			flag = 1; 
		} else if (phone_number.matches(cu)) { 
			flag = 2; 
		} else if (phone_number.matches(ct)) { 
			flag = 3; 
		} else { 
			flag = 4; 
		} 
		return flag; 
	} 
	
	public static void whichOperator(int x){ 
		switch(x){ 
			case 1 : 
				System.out.println("移动号码"); 
				break; 
			case 2: 
				System.out.println("联通号码 "); 
				break; 
			case 3 : 
				System.out.println("电信号码"); 
				break; 
			case 4: 
				System.out.println("输入有误"); 
				break; 
			default:System.out.println("输入有误"); 
		}	
	} 
	
	public static void main(String[] args) { 
		System.out.println("请输入电话号码：");
		Scanner sc = new Scanner(System.in);
		String e = sc.next(); 
		System.out.println("匹配结果：");
		whichOperator(matchesPhoneNumber(e)); 
	}
}


