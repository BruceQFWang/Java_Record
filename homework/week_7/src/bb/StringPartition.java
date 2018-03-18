package bb;

import java.io.*;  
public class StringPartition {    
	public static void main(String[] args) {    
		try {  
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("请输入一串逗号分隔的数字，例如 123,456,789");       
			String str = in.readLine();         
			String strSplit[] = str.split(",");
			int sum = 0;
			for(int i=0;i<strSplit.length;i++){
			    System.out.println("分割为"+strSplit[i]);
				sum += Integer.parseInt(strSplit[i]);
			}
			System.out.println("总和是：" + sum);     
		} 
		catch(Exception e){  
			System.out.println("输入异常：" + e);
		}
	}
}

