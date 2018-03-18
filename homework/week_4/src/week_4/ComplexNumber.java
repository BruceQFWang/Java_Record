package week_4;

public class ComplexNumber {
	private double realPart;
	private double imaginaryPart;
	public static int count = 0;
	ComplexNumber(){
		realPart = 0;
		imaginaryPart = 0;
		count++;
	}
	ComplexNumber(double r, double i){
		realPart = r;
		imaginaryPart = i;
		count++;
	}

	public ComplexNumber add(ComplexNumber x){
		return new ComplexNumber(this.realPart+x.realPart, this.imaginaryPart+x.imaginaryPart);
	}
	
	public ComplexNumber decrease(ComplexNumber x){
		return new ComplexNumber(this.realPart-x.realPart, this.imaginaryPart-x.imaginaryPart);
	}
	
	public ComplexNumber multiply(ComplexNumber x){
		return new ComplexNumber(this.realPart*x.realPart-this.imaginaryPart*x.imaginaryPart, this.realPart*x.imaginaryPart+this.imaginaryPart*x.realPart);
	}
	
	public ComplexNumber divide(ComplexNumber x){
		double div = Math.pow(x.realPart,2)+Math.pow(x.imaginaryPart,2);
		double newReal  = this.realPart*x.realPart+this.imaginaryPart*x.imaginaryPart;
		double newImage  = this.imaginaryPart*x.realPart-this.realPart*x.imaginaryPart;
		return new ComplexNumber(newReal/div, newImage/div);
	}
	
	public String toString(){
		return realPart+"+"+imaginaryPart+"i";
	}
	
	public boolean equals(ComplexNumber x){
		if(this.realPart == x.realPart && this.imaginaryPart == x.imaginaryPart)
			return true;
		else
			return false;
	}
	
	public int hashCode(){
		return this.toString().hashCode();
	}
	
	void FinalizeComplex(){
		count--;
	}
	//获得实部
	public double getreal(){
		return this.realPart;
	}
	//获得虚部
	public double getimag(){
		return this.imaginaryPart;
	}
	//修改实部
	public void setreal(double r){
		this.realPart=r;
	}
	//修改虚部
	public void setimag(double i){
		this.imaginaryPart=i;
	}
	
	public static void main(String[] args){
		ComplexNumber cyber1 = new ComplexNumber();
		ComplexNumber cyber2 = new ComplexNumber(2, 3);
		cyber1.setreal(5); cyber1.setimag(4);
		System.out.println("count = "+ComplexNumber.count);
		System.out.println("cyber1 ="+cyber1.toString());
		System.out.println("cyber2 ="+cyber2.toString());
		System.out.println("cyber1.hashCode() = "+cyber1.hashCode());
		System.out.println("cyber2.hashCode() = "+cyber2.hashCode());
		System.out.println("cyber1+cyber2 ="+cyber1.add(cyber2));
		System.out.println("cyber1-cyber2 ="+cyber1.decrease(cyber2));
		System.out.println("cyber1*cyber2 ="+cyber1.multiply(cyber2));
		System.out.println("cyber1/cyber2 ="+cyber1.divide(cyber2));
		System.out.println("Is cyber1 equal to cyber2? "+cyber1.equals(cyber2));
		cyber1.FinalizeComplex();
		System.out.println(ComplexNumber.count);
	}
}



