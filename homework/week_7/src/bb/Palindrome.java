package bb;

public class Palindrome {    
	public static void main(String[] args) {      
		String str1 = "ɮ��������";   //�ַ������������     
		String str2 = reverse(str1);  //���ô���ת���� 
		System.out.println(str1 + "," + str2); 
		str1 = "�˹������";     
		str2 = reverse(str1);  
		System.out.println(str1 + "," + str2);   
	}     
	public static String reverse(String s){  //����ת���� 
		int len = s.length();      //����������  
		StringBuffer sb = new StringBuffer();  //�ַ������������     
		for (int i =len-1; i>=0;  i-- ) {     
			sb.append(s.charAt(i));  //����������׷�Ӵ������ĵ�i���ַ�s.charAt(i)     
		}      
		return sb.toString(); 
	} 
} 

