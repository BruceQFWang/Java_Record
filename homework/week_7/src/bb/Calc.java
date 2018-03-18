package bb;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calc {
	public static void main(String[] args) {
		System.out.println("请输入你要处理的文本：");
		String regex = "(a|e|i|o|u)";
		String word = "[a-zA-z]{1,}";
		Scanner sc = new Scanner(System.in);
		String chap = sc.nextLine();
		Pattern p1 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Pattern p2 = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
		Matcher m = p1.matcher(chap);
		Matcher n = p2.matcher(chap);
		int end = 0;
		int[] a = {0,0,0,0,0};
		int i = 0;
		while(m.find(end)) {
			if(m.group().equals("a")||m.group().equals("A"))a[0]++;
			else if(m.group().equals("e")||m.group().equals("E"))a[1]++;
			else if(m.group().equals("i")||m.group().equals("I"))a[2]++;
			else if(m.group().equals("o")||m.group().equals("O"))a[3]++;
			else if(m.group().equals("u")||m.group().equals("U"))a[4]++;
			end = m.end();
		}
		end = 0;
		System.out.println("\n输出单词表：");
		while(n.find(end)) {
			System.out.println("单词:\t"+n.group()+"\t长度:"+n.group().length());
			end = n.end();
		}
		System.out.println("\n元音字母数目表：");
		System.out.println("a\\A:\t"+a[0]);
		System.out.println("e\\E:\t"+a[1]);
		System.out.println("i\\I:\t"+a[2]);
		System.out.println("o\\O:\t"+a[3]);
		System.out.println("u\\U:\t"+a[4]);
	}
}
