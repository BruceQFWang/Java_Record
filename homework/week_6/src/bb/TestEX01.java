//package bb;
//
//class A{
//	int x = 1;//������
//	void print(){//������
//		System.out.println("�����Ǹ��෽����x="+x);//����A�ķ����з��ʵı�����Ȼ��A���A�ĸ���ģ������ܷ���B��ġ�
//		m();//����A�ķ����е��õ�ʵ������m()������B�ģ����ڷ����˸���
//	}
//	void m(){//������
//		System.out.println("�����Ǹ����ʵ������m()");
//	}
//	static void m2(){//������
//		System.out.println("�����Ǹ���ľ�̬����m2()");
//	}
//}
//class B extends A{
//	int x = 2; 
//	void print(){
//		System.out.println("���������෽����x="+x);//���෽�����ʵı������������ģ���Ȼ���������������������������
//		System.out.println("���������෽����super.x="+super.x);//super.x�Ǹ�������
//		super.print();//���ø����print()����
//		m();//���ñ������m()����
//	}
//	void m(){
//		System.out.println("�����������ʵ������m()");
//	}
//	static void m2(){
//		System.out.println("����������ľ�̬����m2()");
//	}
//}
//
//public class TestEX01{
//	public static void main(String []s){
//		A p = new B();
//		System.out.println(p.x);//ͨ�����ñ���p�����ʱ�����̬������Ҫ��p���������͡�����x��A��ġ�
//		p.m2();//ͬ�ϡ���̬����m2()��A��ġ�
//		p.print();//ͨ�����ñ���p������ʵ��������Ҫ��pָ��Ķ����ʵ�����͡����ڸ��ǣ����õ�print()����������ġ�
//	}
//}
//
//
//
