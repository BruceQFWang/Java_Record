package bb;

import java.io.*; 
import java.util.Scanner; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
class Number_Exception extends Exception{//创建异常类
	String message; 
	public Number_Exception(String ErrorMessagr){	//父类方法
		this.message = ErrorMessagr;
	} 
	public String getMessage(){		//覆盖getMessage()方法
		return message;
	} 
} 
public class Demo{
	static int JOptionPane(int x,int y)throws Number_Exception{	//定义方法抛出异常
		if(x>100||x<0||y>100||y<0){	//判断参数
			throw new Number_Exception("Number is exceed 100 or under 0 ");	//抛出异常
		}
		return x/y;
	}
	public static void main(String args[]) {
		System.out.println("Input a and b"); 
		Scanner sc=new Scanner(System.in);
		try{
			int a=sc.nextInt(); int b=sc.nextInt();
			JOptionPane(a,b);
			System.out.println("a+b = "+(a+b)); 
			System.out.println("a-b = "+(a-b)); 
			System.out.println("a*b = "+(a*b)); 
			System.out.println("a/b = "+(a/b)); 
		}
		catch(Number_Exception e){	//处理自定义异常
			System.out.println(e.getMessage());	
		}
		catch (ArithmeticException e) { // 处理ArithmeticException异常  
            System.out.println("除数不能为0");   
		} 
		catch (Exception e) { // 处理其他异常  
            System.out.println("程序发生了其他的异常"); 
		} 
	}   
} 

