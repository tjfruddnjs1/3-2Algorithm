package Week_1_assignment;
import java.util.Scanner;

public class recursiveF {
	static int[] arr;		//�Է� �迭 �� ��ͷ� ������ �迭

	public static void main(String[] args) {
		int arrSize;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�迭�� ũ�⸦ �������ּ���");
		arrSize = scan.nextInt();		
		arr = new int[arrSize];
		
		System.out.println("�迭�� ���� �Ҵ����ּ��� �迭�� ũ��� "+arrSize+" �Դϴ�.");
		for(int i=0;i<arrSize;i++) {
			arr[i] = scan.nextInt();	
		}
		
		sum(arrSize-1,arr);
		
		for(int i=0;i<arrSize;i++) {
			System.out.println(arr[i]);
		}
		
		scan.close();
	}
	
	private static int sum(int num, int[] arr) {
		
		if(num == 0) return arr[0];
		
		arr[num] = arr[num] + sum(num-1,arr);
		return arr[num];
	}
}

