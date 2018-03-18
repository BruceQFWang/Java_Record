package week_4;


class Employee{
	private int no; //����
	private String name;
	private int age;
	private int daylyRate;//ÿ����
	private int workDays; //���¹�������
	private String dept; //�������ţ��з��������۲����ۺ�
	private String Tel; //�绰
	public static int count = 0; //ְ������
	public static int finalize = 0; //��������
	//�޲ι���
	Employee(){
		no = 10000;
		count++;
	}
	//�����������
	Employee(int _no, String _name, int _age, int _daylyRate, int _workDays, String _dept, String _Tel){
		this.no = _no;
		this.name = _name;
		this.age = _age;
		this.daylyRate = _daylyRate;
		this.workDays = _workDays;
		this.dept = _dept;
		this.Tel = _Tel;
		count++;
	}
	
	//���ø�������ֵ
	public void setno(int _no){
		this.no = _no;
	}
	public void setname(String _name){
		this.name = _name;
	}
	public void setage(int _age){
		this.age = _age;
	}
	public void setday(int _daylyRate){
		this.daylyRate = _daylyRate;
	}
	public void setworkDays(int _workDays){
		this.workDays = _workDays;
	}
	public void setdept(String _dept){
		this.dept = _dept;
	}
	public void setTel(String Tel){
		this.Tel=Tel;
	}
	
	//�õ���������ֵ
	public int getno(){
		return this.no;
	}
	public String getname(){
		return this.name;
	}
	public int getage(){
		return this.age;
	}
	public int getday(){
		return this.daylyRate;
	}
	public int getworkDays(){
		return this.workDays;
	}
	public String getdept(){
		return this.dept;
	}
	public String getTel(){
		return this.Tel;
	}
	public int getcount(){
		return count;
	}
	public int getfinalize(){
		return finalize;
	}
	//������ʾ����������Ϣ
	public void show(){
		System.out.println("no:"+no+"\t"+"name:"+name+"\t"+"age:"+age+"\t\t"+"daylyRate��"+daylyRate);
		System.out.println("workDays:"+workDays+"\t"+"dept:"+dept+"\t"+"Tel:"+Tel);
	}
	//����ÿ��нˮ
	public int pay(){
		return this.daylyRate*this.workDays;
	}
	void finalize_obj(){
		count--;
		finalize++;
	}
}

class Manager extends Employee{
	private int postPay;//�����λ����
	
	Manager(){ super();}
	Manager(int _postPay){ 
		super();
		this.postPay = _postPay;
	}
	Manager(int _no, String _name, int _age, int _daylyRate, int _workDays, String _dept, String _Tel, int _postPay){
		super(_no, _name, _age, _daylyRate, _workDays, _dept, _Tel);
		this.postPay = _postPay;
	}
	//��ʾ�������ŵ�����Ա��,�������ط�������ʾԱ���Ļ�����Ϣ����ʾԱ����нˮ��
	public void showAll(String _dept, Employee a[]){
		System.out.println(this.getname()+"��������:"+_dept+"\t�ò���Ա���У�");
		for(int i=0; i<a.length; i++){
			if(a[i].getdept() == _dept){
				a[i].show();
				System.out.println(a[i].getname()+"��нˮ��:"+a[i].pay());
			}
		}
	}
	//���¶��壺��̬�ĸ���
	public void show(){
		super.show();
		System.out.println("postPay:"+postPay);
	}
	//���¶��壺����ÿ��нˮ
	public int pay(){
		return getday()*getworkDays()+postPay;
	}
}

public class Demo {
	public static void main(String[] args){
		Employee  a[] = new Employee [3];
		a[0] = new Employee(10001, "Alice", 25, 200, 30, "�з���", "15528330350");
		a[1] = new Employee(66666, "Bob", 23, 300, 30, "�ۺ�", "15528331237");
		a[2] = new Employee(55555, "jyly", 27, 400, 30, "�ۺ�", "15523530350");
		System.out.println("now count is "+Employee.count);
		a[0].show();
		a[1].show();
		a[2].show();
		System.out.println("Alice����н��:"+a[0].pay());
		
		Manager a4 = new Manager(10034, "kaggle", 30, 500, 28, "�ۺ�", "15524138947", 3000);
		System.out.println("now count is "+Employee.count);
		a4.showAll("�ۺ�", a);
		a4.show();
		System.out.println(a4.getname()+"����н��:"+a4.pay());
		a[0].finalize_obj();
		System.out.println("Alice is dismissed,now count is "+Employee.count);
	}
}

