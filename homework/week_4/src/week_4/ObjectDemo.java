package week_4;

class Book{
	private String name;
	private float price;
	public Book(String name,float price){
		this.name=name;
		this.price=price;
	}
	public void print(Book b){
		System.out.println("直接输出对象: "+b);
		System.out.println("toString: "+b.toString());
		System.out.println("hashCode: "+Integer.toHexString(b.hashCode()));
		System.out.println("getClass "+b.getClass());
	}
}

public class ObjectDemo {
	public static void main(String []args){
		Book b1,b2;
		b1=new Book("Java",32.5f);
		b1.print(b1);
		b2=new Book("C++",36.5f);
		b2.print(b2);
		System.out.println("is equal: "+b1.equals(b2));
	}
}
