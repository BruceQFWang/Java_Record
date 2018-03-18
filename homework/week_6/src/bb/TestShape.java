package bb;

interface shape{
	double  PI =3.1415926f;
    void  draw();         //绘制图形，在程序中用信息输出表示
    double getArea();      // 获取面积
    double  getCircumference();  // 周长
}

class Circle implements shape {
	double r;
	public Circle(double r) { this.r = r; }
	public void draw() {}
	public double getArea() { return shape.PI * r * r; }
	public double getCircumference() { 
		return 2 * shape.PI * r * r; 
	}
}

class Eclipse implements shape {
	double a, b;
	public Eclipse(double a, double b) { this.a = a; this.b = b; }
	public void draw() {}
	public double getArea() { return shape.PI * a * b; }
	public double getCircumference() { 
		return 4 * ((a + b) - (4 - shape.PI) * a * b / (a + b)); 
	}
}

class Rectangle implements shape {
	double a, b;
	public Rectangle(double a, double b) { this.a = a; this.b = b; }
	public void draw() {}
	public double getArea() { return a * b; }
	public double getCircumference() {
		return 2 * (a + b); 
	}
}

class Triangle implements shape {
	double a, b, c;
	public Triangle(double a, double b, double c) { 
		this.a = a; this.b = b; this.c = c;  
	}
	public void draw() {}
	public double getArea() { 
		double p = (a + b + c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}	
	public double getCircumference() { 
		return a + b + c; 
	}
}

public class TestShape {
	public static void main(String[] args){
		Circle cir = new Circle(5.0);
		Eclipse ecl = new Eclipse(3.0, 4.0);
		Rectangle rec = new Rectangle(4.0, 5.0);
		Triangle tri = new Triangle(3.0, 4.0, 5.0);
		System.out.println("圆的面积："+cir.getArea());
		System.out.println("圆的周长："+cir.getCircumference());
		System.out.println("椭圆的面积："+ecl.getArea());
		System.out.println("椭圆的周长："+ecl.getCircumference());
		System.out.println("矩形的面积："+rec.getArea());
		System.out.println("矩形的周长："+rec.getCircumference());
		System.out.println("三角形的面积："+tri.getArea());
		System.out.println("三角形的周长："+tri.getCircumference());
	}
}
