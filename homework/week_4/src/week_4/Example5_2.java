package week_4;

class TestStatic{
	public int i= 3;//声明成员变量
	public static int s=5;//声明静态变量
	public void counta(){	//非静态方法
		System.out.println("执行成员方法 counta()");
		System.out.println ("i=" + i);	//直接调用成员变量
		System.out.println ("s=" + s);	//直接调用静态变量
	}
	public static void sTest(){	//静态方法
		System.out.println ("执行静态方法 sTest()");
		TestStatic test=new TestStatic();
		test.i=test.i + 3; //静态方法中闲用非静态变量,:要创建类的对象
		System.out.println("i="+test.i);
		s=s + 5;	//直接调用静态变量
		System.out.println("s="+s);
	}
}
public class Example5_2{
	public static void main (String [] args){	//主方法
		System.out.println("执行主方法");
		TestStatic t=new TestStatic();	//创建类的对象
		System.out.println("t.s="+t.i);
		System.out.println("t.s="+t.s);	//输出实例变量和类变量的值
		System.out.println("TestStatic.s="+TestStatic.s);
		t.counta();		//使用对象调用成员方法
		t.sTest();		//使用对象闲用类方法
		TestStatic.sTest ();	//使用类名直接调用类方法
	}	
}



