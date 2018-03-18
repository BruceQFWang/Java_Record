package bb;

interface Flyanimal {
	void fly();
}

class Insect {
	int leg = 6;
	void spawn() { System.out.println("²úÂÑ"); }
}

class Bird {
	int leg = 2;
	void layegg() { System.out.println("Éúµ°");}
}

class Pigeon extends Bird implements Flyanimal  {
	public void fly() { System.out.println("Pigeon can fly"); }
}

class Geese extends Bird implements Flyanimal {
	public void fly() { System.out.println("Geese can fly"); }
}

class Ant extends Insect implements Flyanimal {
	public void fly() { System.out.println("Ant can't fly"); }
}

class Bee extends Insect implements Flyanimal {
	public void fly() { System.out.println("Bee can fly"); }
}


public class Testanimal {
	public static void main(String[] args){
		Pigeon pig = new Pigeon();
		Geese  gee = new Geese();
		Ant an = new Ant();
		Bee be = new Bee();
		pig.fly(); pig.layegg();
		gee.fly(); gee.layegg();
		an.fly(); an.spawn();
		be.fly(); be.spawn();
	}
}
