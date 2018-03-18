package week_3;

import java.util.Arrays;  
public class a01_2 {
	public static void main(String[] args){
		int myArray[] = { 1, 2, 3, 4, 5, 6 };
		int yourArray[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int hisArray[] = {12,42,34,5,-34,36,323,-233,43,12};
		Arrays.sort(hisArray);
		int pos = Arrays.binarySearch(hisArray, 12);
		if(pos >= 0)System.out.println("指定元素的位置为："+pos);
		else System.out.println("no found");	
	}
}





