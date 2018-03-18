package week_3;

import java.util.Arrays; 
import java.util.Random; 
public class arc1_4 {
	public static void main(String[] args){
		int a[] = new int[100];
		Random rand = new Random();
		for(int i=0; i<100; i++){
			int x = rand.nextInt(5)+1;
			a[i] = x;
		}
		int cnt[] = new int[6];
		for(int i=0; i<100; i++)cnt[a[i]]++;
		System.out.println("Grade       Count  Histogram");
		for(int i=1; i<=5; i++){
			System.out.print(i+"           "+cnt[i]+"   ");
			for(int j=1; j<=cnt[i]; j++)System.out.print("*");
			System.out.println("");
		}
	}
}
