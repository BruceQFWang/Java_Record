package week_3;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MyDate {
	int year;
	int month;
	int day;
	int num_order;// �������������е����룬int���ͣ�ֻҪ����showTips()��������ź����ڵ��޸�
	boolean flag = true;// ���Ƴ�����˳�����flag = falseʱ���˳�
	public MyDate(){
		year = 2012;
		month = 3;	
		day = 14;
	}
	// ���캯��
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	// showTips()������ʾ�û���ز�������
	public void showTips() {
		System.out.println("1�޸����");
		System.out.println("2�޸��·�");
		System.out.println("3�޸�����");
		System.out.println("4�޸�ȫ��");
		System.out.println("5�˳��޸�");
	}
	public void changeDate() { //�޸����ڵĺ���
		Scanner _order = new Scanner(System.in);
		System.out.print("�������������");
		//����������쳣û�в���
		num_order = _order.nextInt();
		if (num_order == 1) {
			System.out.println("�������µ���ݣ�");
			year = _order.nextInt();
			System.out.println();
		} 
		else if (num_order == 2) {
			System.out.println("�������µ��·ݣ�");
			month = _order.nextInt();
			System.out.println();
		} 
		else if (num_order == 3) {
			System.out.println("�������µ��շݣ�");
			day = _order.nextInt();
			System.out.println();
		} 
		else if (num_order == 4) {
			System.out.println("�������µ���ݣ�");
			year = _order.nextInt();
			System.out.println("�������µ��·ݣ�");
			month = _order.nextInt();
			System.out.println("�������µ��շݣ�");
			day = _order.nextInt();
			System.out.println();
		}
		else if (num_order == 5) {
			flag = false;
			System.out.println("�������");
		}
	}
	public void displayDate() { //������ڵ����ں���
		if (month>= 0 &&month<= 12 &&day>= 1 &&day<= 31) {
			System.out.println("Ŀǰ������Ϊ��" + year + "��" + month + "��" + day+ "��");
		} 
		else {
			System.out.println("�������������������������ȷ�Ϻ�����������");
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
				System.out.println("����������Ҫ��һ�£���ȷ������������!");
				mydate.changeDate();
			}
		}
	}
}