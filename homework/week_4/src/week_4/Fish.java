package week_4;

class Animal{	//子类构造方法的定义
	protected String name;
	Animal(){}
	public Animal(String n){	//超类定义带参构造方法 
		name= n; 
	} 
	public void Showlnfo(){
		System.out.print("the animal\t");
		System.out.print(name+"\t");
	}
}
public class Fish extends Animal{ 
	int SwimSpeed;
	Fish(String n,int s){	//子类定义带参构造方法
		name=n;	
		SwimSpeed=s;
	}
	public void ShowInfo(){
		System.out.print("the Fish\t"+name +"\t"); 
		System.out.print("Swimmingspeed:\t"+ SwimSpeed);
	}
	public static void main(String args[]){ 
		Fish a = new Fish("Nemo",60); 
		a.ShowInfo();
	}
}