package cd;

import java.util.Scanner;

public class bank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float account = 10000.0f;
		boolean flag = true;

		while (flag) {
			System.out.println("******������Ϣ����ϵͳ******");
			System.out.println("�й����л�ӭ��");
			System.out.println("��ѡ��(������1~4ѡ�����Ĳ���)");
			System.out.println("1.��ѯ���");
			System.out.println("2.���");
			System.out.println("3.ȡ��");
			System.out.println("4.�˳�");
			System.out.println("������ֵ�������������������");
			System.out.println("**********************");

			int num = scan.nextInt();
			int qk;
			int ck;
			switch (num) {
				case 1:
					System.out.println("���������Ϊ��" + account);
					break;
				case 2:
					System.out.println("��ѡ����Ҫ�������");
					ck = scan.nextInt();
					if (ck < 0) {
						System.out.println("����ȡ��ֵ�Ĵ��");
					} else if (ck % 100 == 0) {
						account += ck;
						System.out.println("����" + ck + "�ɹ�");
					} else {
						System.out.println("���ʧ�ܣ������100������");
					}
					break;
				case 3:
					System.out.println("��ѡ����Ҫȡ������");
					qk = scan.nextInt();
					if (qk < 0) {
						System.out.println("����ȡ��ֵ�Ĵ��");
					} else if (qk >= account) {
						System.out.println("����");
					} else if (qk % 100 == 0) {
						account -= qk;
						System.out.println("ȡ��" + qk + "�ɹ�");
					} else {
						System.out.println("ȡ��ʧ�ܣ���ȡ��100������");
					}
					break;
				case 4:
					System.out.println("�˳�");
					System.exit(0);
			}

		}
	}
}
