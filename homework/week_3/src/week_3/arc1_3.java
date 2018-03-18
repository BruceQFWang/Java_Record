package week_3;

import java.util.Arrays; 
import java.util.Random; 
public class arc1_3 {
	public static void main(String[] args){
		int a[] = new int[20];
		Random rand = new Random();
		for(int i=0; i<20; i++){
			while(true){
				int x = rand.nextInt(50);
				boolean fg = true;
				for(int j=0; j<i; j++)if(a[j] == x){
						fg = false;
						break;
					}
				if(fg){
					a[i] = x;
					break;
				}
			}
		}
		Arrays.sort(a);
		for(int i=0; i<20; i++)System.out.print(a[i] + " ");
		System.out.println();
		double ave = 0.0;
		for(int i=0; i<20; i++)ave += a[i];
		ave /= 20;
		System.out.println("平均值为："+ave);
	}
}
