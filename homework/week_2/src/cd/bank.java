package cd;

import java.util.Scanner;

public class bank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float account = 10000.0f;
		boolean flag = true;

		while (flag) {
			System.out.println("******银行信息管理系统******");
			System.out.println("中国银行欢迎您");
			System.out.println("请选择(请输入1~4选择您的操作)");
			System.out.println("1.查询余额");
			System.out.println("2.存款");
			System.out.println("3.取款");
			System.out.println("4.退出");
			System.out.println("其他数值：输入错误，请重新输入");
			System.out.println("**********************");

			int num = scan.nextInt();
			int qk;
			int ck;
			switch (num) {
				case 1:
					System.out.println("您卡上余额为：" + account);
					break;
				case 2:
					System.out.println("请选择您要存款的数额：");
					ck = scan.nextInt();
					if (ck < 0) {
						System.out.println("不能取负值的存款");
					} else if (ck % 100 == 0) {
						account += ck;
						System.out.println("存入" + ck + "成功");
					} else {
						System.out.println("存款失败，请存入100的整数");
					}
					break;
				case 3:
					System.out.println("请选择您要取款的数额：");
					qk = scan.nextInt();
					if (qk < 0) {
						System.out.println("不能取负值的存款");
					} else if (qk >= account) {
						System.out.println("余额不足");
					} else if (qk % 100 == 0) {
						account -= qk;
						System.out.println("取出" + qk + "成功");
					} else {
						System.out.println("取款失败，请取出100的整数");
					}
					break;
				case 4:
					System.out.println("退出");
					System.exit(0);
			}

		}
	}
}
