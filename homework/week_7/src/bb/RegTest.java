package bb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegTest{  
	static void test(){
		Pattern p = null; //������ʽ
		Matcher m = null; //�������ַ���
		boolean b = false;
		//������ʽ��ʾ15λ����18λ���ֵ�һ������
		p = Pattern.compile("[^0](\\d{14}|\\d{17})*");
		m = p.matcher("120101198506020080");
		b = m.matches();
		p = Pattern.compile("[^0](\\d{14}|\\d{17})*");
		System.out.println("���֤������ȷ��"+b); //�����true	
		m = p.matcher("020101198506020080");//���� ��λΪ0
		b = m.matches();
		System.out.println("���֤�������"+b); //�����false
	}
	public static void main(String argus[]){   
		test();
	}
}

