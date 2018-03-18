package week_3;

public class Circle
{ 	private float r;//定义私有变量圆半径
	Circle (){}	//定义空构造函数
	Circle (float x) //定义空构造函数并初始化变量 r。
	{r=x;}
	public void set_value(float x) //初始化圆半径的值
	{ r=x; }
	public double mj() //求圆面积
	{ return(3.14*r*r); }
	public double zc() //求圆周长
	{ 	double y;
		y=2*3.14*r;
		return(y);
	}
	public static void main(String args[])
	{ 	Circle ex1 = new Circle(), ex2 = new Circle();  //定义类 Circle 对象（或类变量）并初始化
		ex1.set_value(3.2f); //初始化 Circle 类对象圆半径的值
		System.out.println("面积="+ex1.mj()+"周长="+ex1.zc());
		ex2.set_value(5.5f); //定义类 Circle 对象并设置半径为 5.5.
		System.out.println("面积="+ex2.mj()+"周长="+ex2.zc());
	}
}
