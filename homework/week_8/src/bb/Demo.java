package bb;

import java.io.*; 
import java.util.Scanner; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
class Number_Exception extends Exception{//�����쳣��
	String message; 
	public Number_Exception(String ErrorMessagr){	//���෽��
		this.message = ErrorMessagr;
	} 
	public String getMessage(){		//����getMessage()����
		return message;
	} 
} 
public class Demo{
	static int JOptionPane(int x,int y)throws Number_Exception{	//���巽���׳��쳣
		if(x>100||x<0||y>100||y<0){	//�жϲ���
			throw new Number_Exception("Number is exceed 100 or under 0 ");	//�׳��쳣
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
		catch(Number_Exception e){	//�����Զ����쳣
			System.out.println(e.getMessage());	
		}
		catch (ArithmeticException e) { // ����ArithmeticException�쳣  
            System.out.println("��������Ϊ0");   
		} 
		catch (Exception e) { // ���������쳣  
            System.out.println("���������������쳣"); 
		} 
	}   
} 

