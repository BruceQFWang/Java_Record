package bb;

import java.io.*;  
public class StringPartition {    
	public static void main(String[] args) {    
		try {  
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("������һ�����ŷָ������֣����� 123,456,789");       
			String str = in.readLine();         
			String strSplit[] = str.split(",");
			int sum = 0;
			for(int i=0;i<strSplit.length;i++){
			    System.out.println("�ָ�Ϊ"+strSplit[i]);
				sum += Integer.parseInt(strSplit[i]);
			}
			System.out.println("�ܺ��ǣ�" + sum);     
		} 
		catch(Exception e){  
			System.out.println("�����쳣��" + e);
		}
	}
}

