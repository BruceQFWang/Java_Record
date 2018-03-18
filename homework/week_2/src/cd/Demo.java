package cd;


//import java.util.Scanner;
//
//public class Demo {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入一个整数：");
//		int num = sc.nextInt(); //从键盘接收一个整数
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




//import java.util.Arrays; //导入数组类
//import java.util.Random; //随机数生成类Random
//
//public class Demo {
//	public static void main(String[] args){
//		//先建一个对象
//		//可以提供一个随机数种子，默认是系统时间
//		Random rand = new Random();
//		
//		//布尔型随机数
//		System.out.println("rand.nextBoolean: "+rand.nextBoolean());
//		
//		byte[] buffer = new byte[16];
//		//为一个byte数组赋随机数
//		rand.nextBytes(buffer);
//		System.out.println(Arrays.toString(buffer)); //数组转换为字符串
//		
//		//生成0.0~1.0之间的伪随机数
//		System.out.println("rand.nextDouble: "+rand.nextDouble());
//		
//		//生成0.0~1.0之间的伪随机数
//		System.out.println("rand.nextFloat: "+rand.nextFloat());
//		
//		//生成一个整数取值范围内的伪随机数
//		System.out.println("rand.nextInt: "+rand.nextInt());
//		
//		//生成0~26之间的伪随机数
//		System.out.println("rand.nextInt(26): "+rand.nextInt(26));
//		
//		//生成0.0~1.0之间的伪随机数
//		System.out.println("rand.nextLong: "+rand.nextLong());
//	}
//}

import java.util.Scanner;
import java.util.Random; //随机数生成类Random

public class Demo {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你猜的数：");
		int guess = sc.nextInt();
		Random rand = new Random();
		int ans = rand.nextInt(5)+1;
		System.out.println("筛子点数为："+ans);
		if(guess == ans)System.out.println("恭喜你，猜对了！");
		else System.out.println("很遗憾，猜错了！");
	}
}
