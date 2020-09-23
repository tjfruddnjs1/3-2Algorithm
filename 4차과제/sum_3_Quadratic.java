package Week_4_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class sum_3_Quadratic {

	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("배열의 크기를 입력하세요.");
		int arr_size = scan.nextInt();
		int[] array = new int[arr_size];
		
		System.out.println("배열에 요소 값을 지정해주세요.");
		for(int i=0;i<arr_size;i++) {
			array[i] = scan.nextInt();
		}
		scan.close();
		
		//step 1 : 배열 오름차순 정렬
		Arrays.sort(array);
		
		//N^2의 2개의 반복문
		for(int i=0;i<arr_size-2;i++) {
			//첫번째 조합 숫자
			int num_1 = array[i];
			int left = i+1;
			int right = arr_size-1;
			while(left<right) {
				//두번째, 세번째 조합 숫자
				int num_2 = array[left];
				int num_3 = array[right];
				
				//합이 0이 되었을때 break문을 걸지 않고, num_1에 해당하는 다른 조합을 생각해서 left,right값만 바꿔줌
				if(num_1+num_2+num_3 == 0) {
					count++;
					left++;
					right--;
				//0보다 클때, 오름차순인 경우 오른쪽 숫자가 크기 때문에 줄여준다
				}else if(num_1+num_2+num_3 > 0) {
					right--;
				//0보다 작을때, 오름차순인 경우 왼쪽 숫자가 작기 때문에 키워준다
				}else {
					left++;
				}
			}			
		}
		
		System.out.println("조합의 가능한 갯수는 : "+ count +" 개 입니다.");
	}
}
