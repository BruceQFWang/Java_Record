package week_3;

public class Demo {
	public static void main(String[] args){
		int i, j;
		int a[] = {2, 1, 4, 8, 9, 5, 3};
		for(i = 0; i < a.length-1; i++){
			int k = i;
			for(j = i; j < a.length; j++){
				if(a[j] < a[k])k = j;
			}
			int temp = a[i];
			a[i] = a[k];
			a[k] = temp;
		}
		for(int x : a)System.out.print(x + " ");
		System.out.println();
	}
}
