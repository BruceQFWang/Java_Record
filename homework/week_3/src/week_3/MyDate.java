package week_3;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MyDate {
	int year;
	int month;
	int day;
	int num_order;// 接受来自命令行的输入，int类型，只要负责showTips()的命令代号和日期的修改
	boolean flag = true;// 控制程序的退出，当flag = false时，退出
	public MyDate(){
		year = 2012;
		month = 3;	
		day = 14;
	}
	// 构造函数
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	// showTips()用于提示用户相关操作代号
	public void showTips() {
		System.out.println("1修改年份");
		System.out.println("2修改月份");
		System.out.println("3修改日期");
		System.out.println("4修改全部");
		System.out.println("5退出修改");
	}
	public void changeDate() { //修改日期的函数
		Scanner _order = new Scanner(System.in);
		System.out.print("请输入您的命令：");
		//下面的数字异常没有捕获
		num_order = _order.nextInt();
		if (num_order == 1) {
			System.out.println("请输入新的年份：");
			year = _order.nextInt();
			System.out.println();
		} 
		else if (num_order == 2) {
			System.out.println("请输入新的月份：");
			month = _order.nextInt();
			System.out.println();
		} 
		else if (num_order == 3) {
			System.out.println("请输入新的日份：");
			day = _order.nextInt();
			System.out.println();
		} 
		else if (num_order == 4) {
			System.out.println("请输入新的年份：");
			year = _order.nextInt();
			System.out.println("请输入新的月份：");
			month = _order.nextInt();
			System.out.println("请输入新的日份：");
			day = _order.nextInt();
			System.out.println();
		}
		else if (num_order == 5) {
			flag = false;
			System.out.println("程序结束");
		}
	}
	public void displayDate() { //输出现在的日期函数
		if (month>= 0 &&month<= 12 &&day>= 1 &&day<= 31) {
			System.out.println("目前的日期为：" + year + "年" + month + "月" + day+ "日");
		} 
		else {
			System.out.println("您的输入与设计情况不相符，请确认后重新来过！");
		}
		showTips();
		changeDate();
	}
	public static void main(String[] args) {
		MyDate mydate = new MyDate();
		while (mydate.flag) {
			try {
				mydate.displayDate();
			} 
			catch (InputMismatchException ime) {
				System.out.println("您的输入与要求不一致，请确定后重新来过!");
				mydate.changeDate();
			}
		}
	}
}