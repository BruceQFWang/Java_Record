package week_4;


class A1{
	static int x = 2;
	public void setX(int i){
		x = i;
	}
	void printa(){
		System.out.println(x);
	}
}

class B1 extends A1{
	int x = 100;
	void printb(){
		super.x = super.x+10;
		System.out.println("super.x=" + super.x + " x=" + x);
	}
}

public class Exam4_4Test {
	public static void main(String[] args){
		A1 a1 = new A1();
		a1.setX(4);
		a1.printa();
		
		B1 b1 = new B1();
		b1.printb();
		b1.printa();
		
		b1.setX(6);
		b1.printb();
		b1.printa();
		a1.printa();
	}	
}

