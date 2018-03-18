package week_3;

import java.util.Arrays; 
import java.util.Scanner;
public class Student {
	private int no, age;
	private double score[];
	private String name;
	static int count = 0;
	Student(){}
	Student(int no, int age, String name) {
		count++;
		this.no = no;
		this.age = age;
		this.name = name;
		set_score();
	}
	//������ø����ԣ�ѧ�š����������䣩
	int getno(){ 
		return no;
	}
	int getage(){
		return age;
	}
	String getname(){
		return name;
	}
	//�������ø����ԣ�ѧ�š����������䣩
	void set_no(int _no){
		no = _no;
	}
	void set_age(int _age){
		age = _age;
	}
	void set_name(String _name){
		name = _name;
	}
	void set_score(){ 
		System.out.println("��"+count+"��ѧ����");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������Ŀ����");
		int n = sc.nextInt();
		score = new double[n];
		for(int i=1; i<=n; i++){
			System.out.print("�������"+i+"�Ƴɼ���");
			score[i-1] = sc.nextDouble();
		}
	}
	String get_score(){
		return Arrays.toString(this.score);
	}
	//��ƽ���ɼ�
	double get_ave(){
		double ans = 0.0;
		for(double x : score)ans += x;
		ans /= score.length;
		return ans;
	}
	//��������������Ϣ��ϳ�һ���ַ���
	public String change(){
		return "ѧ��:"+getno()+" ������"+getname()+" ���䣺"+getage()+" ���Ƴɼ���"+get_score()+" ƽ���ɼ���"+get_ave();
	}
	
	public static void main(String[] args){
		Student s[] = new Student[2];
		s[0] = new Student(2015111948, 20, "�����");
		s[1] = new Student(2015111666, 25, "Alice");
		System.out.println("���ѧ����Ϣ��");
		for(int i=1; i<=2; i++){
			System.out.println("��"+i+"��ѧ��������ϢΪ�� "+s[i-1].change());
		}
		s[0].set_name("Bob");
		s[0].set_age(16);
		System.out.println("����޸ĺ��һ��ѧ����Ϣ��"+s[0].change());
	}
}


