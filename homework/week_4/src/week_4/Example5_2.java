package week_4;

class TestStatic{
	public int i= 3;//������Ա����
	public static int s=5;//������̬����
	public void counta(){	//�Ǿ�̬����
		System.out.println("ִ�г�Ա���� counta()");
		System.out.println ("i=" + i);	//ֱ�ӵ��ó�Ա����
		System.out.println ("s=" + s);	//ֱ�ӵ��þ�̬����
	}
	public static void sTest(){	//��̬����
		System.out.println ("ִ�о�̬���� sTest()");
		TestStatic test=new TestStatic();
		test.i=test.i + 3; //��̬���������÷Ǿ�̬����,:Ҫ������Ķ���
		System.out.println("i="+test.i);
		s=s + 5;	//ֱ�ӵ��þ�̬����
		System.out.println("s="+s);
	}
}
public class Example5_2{
	public static void main (String [] args){	//������
		System.out.println("ִ��������");
		TestStatic t=new TestStatic();	//������Ķ���
		System.out.println("t.s="+t.i);
		System.out.println("t.s="+t.s);	//���ʵ���������������ֵ
		System.out.println("TestStatic.s="+TestStatic.s);
		t.counta();		//ʹ�ö�����ó�Ա����
		t.sTest();		//ʹ�ö��������෽��
		TestStatic.sTest ();	//ʹ������ֱ�ӵ����෽��
	}	
}



