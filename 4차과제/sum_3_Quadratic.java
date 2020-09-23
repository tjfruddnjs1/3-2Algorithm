package Week_4_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class sum_3_Quadratic {

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
		
		//N^2�� 2���� �ݺ���
		for(int i=0;i<arr_size-2;i++) {
			//ù��° ���� ����
			int num_1 = array[i];
			int left = i+1;
			int right = arr_size-1;
			while(left<right) {
				//�ι�°, ����° ���� ����
				int num_2 = array[left];
				int num_3 = array[right];
				
				//���� 0�� �Ǿ����� break���� ���� �ʰ�, num_1�� �ش��ϴ� �ٸ� ������ �����ؼ� left,right���� �ٲ���
				if(num_1+num_2+num_3 == 0) {
					count++;
					left++;
					right--;
				//0���� Ŭ��, ���������� ��� ������ ���ڰ� ũ�� ������ �ٿ��ش�
				}else if(num_1+num_2+num_3 > 0) {
					right--;
				//0���� ������, ���������� ��� ���� ���ڰ� �۱� ������ Ű���ش�
				}else {
					left++;
				}
			}			
		}
		
		System.out.println("������ ������ ������ : "+ count +" �� �Դϴ�.");
	}
}
