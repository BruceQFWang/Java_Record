package bb;

interface StudentManageInterface{
	public abstract void setFee(int fee);
	public abstract int getFee();
}

interface TeacherManageInterface{
	public abstract void setPay(int pay);
	public abstract int getPay();
}

class Graduate implements StudentManageInterface, TeacherManageInterface{
	int name, xingbie, age, fee, pay;
	public void setFee(int fee) { this.fee = fee; }
	public int getFee() { return fee; }
	public void setPay(int pay) { this.pay = pay; }
	public int getPay() { return pay; }
}

public class Demo {
	public static void main(String[] args){
		Graduate zhangsan = new Graduate();
		zhangsan.setFee(4000);
		zhangsan.setPay(5000);
		if (zhangsan.getPay() - zhangsan.getFee() < 2000)
			System.out.println("provide a loan");
	}
}
