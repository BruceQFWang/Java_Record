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
	//声明获得各属性（学号、姓名和年龄）
	int getno(){ 
		return no;
	}
	int getage(){
		return age;
	}
	String getname(){
		return name;
	}
	//声明设置各属性（学号、姓名和年龄）
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
		System.out.println("第"+count+"个学生：");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入科目数：");
		int n = sc.nextInt();
		score = new double[n];
		for(int i=1; i<=n; i++){
			System.out.print("请输入第"+i+"科成绩：");
			score[i-1] = sc.nextDouble();
		}
	}
	String get_score(){
		return Arrays.toString(this.score);
	}
	//求平均成绩
	double get_ave(){
		double ans = 0.0;
		for(double x : score)ans += x;
		ans /= score.length;
		return ans;
	}
	//将该类所有域信息组合成一个字符串
	public String change(){
		return "学号:"+getno()+" 姓名："+getname()+" 年龄："+getage()+" 各科成绩："+get_score()+" 平均成绩："+get_ave();
	}
	
	public static void main(String[] args){
		Student s[] = new Student[2];
		s[0] = new Student(2015111948, 20, "王秋锋");
		s[1] = new Student(2015111666, 25, "Alice");
		System.out.println("输出学生信息：");
		for(int i=1; i<=2; i++){
			System.out.println("第"+i+"个学生，其信息为： "+s[i-1].change());
		}
		s[0].set_name("Bob");
		s[0].set_age(16);
		System.out.println("输出修改后第一个学生信息："+s[0].change());
	}
}


