package Week_4_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class sum_3_QuadraticXlogarithmic {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�迭�� ũ�⸦ �Է��ϼ���.");
		int arr_size = scan.nextInt();
		int[] array = new int[arr_size];
		
		System.out.println("�迭�� ��� ���� �������ּ���.");
		for(int i=0;i<arr_size;i++) {
			array[i] = scan.nextInt();
		}
		scan.close();
		
		//step 1 : �迭 �������� ����
		Arrays.sort(array);
		
		//step 2 : array[i] + array[j]�� 0���� ����� ���� ����Ž���� ���� Ȯ��
		for(int i=0;i<arr_size;i++) {
			
			for(int j=i+1;j<arr_size;j++) {
				int key = -(array[i] + array[j]);
				int index = binarySearch(array, key);
				
				//Ž���Ǹ鼭, ���� �������� ���� ������ ����(count) ���� 
				if(index != -1 && array[i] != array[index] && array[j] != array[index]) {
					//���� Ȯ���� ���� print��
					System.out.println("("+array[i]+" "+array[j]+" "+array[index]+")");
					count++;
				}
			}
		}
		
		//3���� ���� �ٸ� ������ �ֱ� ������ 3�� ������
		System.out.println("������ ������ ������ : "+ count/3 +" �� �Դϴ�.");
	}
	
	//���� Ž��
	private static int binarySearch(int[] array, int key) {
		
		int left = 0;
		int right = array.length-1;
		
		while(right >= left) {
			int mid = left + (right-left) / 2;
			
			if(key < array[mid]) right = mid-1;
			else if (key > array[mid]) left = mid+1;
			else return mid;
		}
		
		//Ž������ ����
		return -1;
	}
}
