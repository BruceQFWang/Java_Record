package cd;


//import java.util.Scanner;
//
//public class Demo {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		System.out.println("������һ��������");
//		int num = sc.nextInt(); //�Ӽ��̽���һ������
//		int a, b, c, m;
//		a = num / 100;
//		b = num % 100 / 10;
//		c = num % 100 % 10;
//		m = a + b + c;
//		System.out.println("a=" + a);
//		System.out.println("b=" + b);
//		System.out.println("c=" + c);
//		System.out.println("m=" + m);
//	}
//}




//import java.util.Arrays; //����������
//import java.util.Random; //�����������Random
//
//public class Demo {
//	public static void main(String[] args){
//		//�Ƚ�һ������
//		//�����ṩһ����������ӣ�Ĭ����ϵͳʱ��
//		Random rand = new Random();
//		
//		//�����������
//		System.out.println("rand.nextBoolean: "+rand.nextBoolean());
//		
//		byte[] buffer = new byte[16];
//		//Ϊһ��byte���鸳�����
//		rand.nextBytes(buffer);
//		System.out.println(Arrays.toString(buffer)); //����ת��Ϊ�ַ���
//		
//		//����0.0~1.0֮���α�����
//		System.out.println("rand.nextDouble: "+rand.nextDouble());
//		
//		//����0.0~1.0֮���α�����
//		System.out.println("rand.nextFloat: "+rand.nextFloat());
//		
//		//����һ������ȡֵ��Χ�ڵ�α�����
//		System.out.println("rand.nextInt: "+rand.nextInt());
//		
//		//����0~26֮���α�����
//		System.out.println("rand.nextInt(26): "+rand.nextInt(26));
//		
//		//����0.0~1.0֮���α�����
//		System.out.println("rand.nextLong: "+rand.nextLong());
//	}
//}

import java.util.Scanner;
import java.util.Random; //�����������Random

public class Demo {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("��������µ�����");
		int guess = sc.nextInt();
		Random rand = new Random();
		int ans = rand.nextInt(5)+1;
		System.out.println("ɸ�ӵ���Ϊ��"+ans);
		if(guess == ans)System.out.println("��ϲ�㣬�¶��ˣ�");
		else System.out.println("���ź����´��ˣ�");
	}
}
