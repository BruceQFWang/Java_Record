package bb;

public class TestBoxType {
	   public static void main(String[] args) 
	   {
	        int a = 1;
	        String str = "123";
	        Integer b = a;  //�Զ�װ��
	        int c = b;//�Զ�����
	        Integer d = new Integer(a);  //�ֶ�װ��
	        int e = d.intValue();//�ֶ�����
	        /*
	           *ʵ��int������String����֮��Ļ�ת
	        */
	        //intת��String
	        int i = 123;
	        //ת����ʼ
	        String s1 = i+"";//��һ�ַ���
	        String s2 = String.valueOf(i);//�ڶ��ַ���
	        String s3 = Integer.toString(i);//�����ַ���
	        //�����������ת�����
	        System.out.println(s1);
	        System.out.println(s2);
	        System.out.println(s3);
	        //Stringת��int
	        String s = "456";
	        //��ʼת��
	        int i1 = Integer.valueOf(s);//��һ�ַ���
	        int i2 = Integer.parseInt(s);//�ڶ��ַ���
	        //�������ת�����
	        System.out.println(i1);
	        System.out.println(i2);        
	     } 
	 }

