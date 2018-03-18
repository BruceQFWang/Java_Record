package bb;

interface shape{
	double  PI =3.1415926f;
    void  draw();         //����ͼ�Σ��ڳ���������Ϣ�����ʾ
    double getArea();      // ��ȡ���
    double  getCircumference();  // �ܳ�
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
		System.out.println("Բ�������"+cir.getArea());
		System.out.println("Բ���ܳ���"+cir.getCircumference());
		System.out.println("��Բ�������"+ecl.getArea());
		System.out.println("��Բ���ܳ���"+ecl.getCircumference());
		System.out.println("���ε������"+rec.getArea());
		System.out.println("���ε��ܳ���"+rec.getCircumference());
		System.out.println("�����ε������"+tri.getArea());
		System.out.println("�����ε��ܳ���"+tri.getCircumference());
	}
}
