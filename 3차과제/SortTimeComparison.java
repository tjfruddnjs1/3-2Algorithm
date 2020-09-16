package Week_3_assignment;

import java.util.Scanner;

public class SortTimeComparison {
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
			
		double[] exArr = new double[100000];
		
		for(int i=0;i<exArr.length;i++) {
			exArr[i] = (double)(Math.random() * 10000 +1);
		}
		
		insertionSort insert = new insertionSort(exArr);
		selectionSort select = new selectionSort(exArr);
		shellSort shell = new shellSort(exArr);
		
		insert.sort();
		select.sort();
		shell.sort();
		
		scan.close();
	}
}


