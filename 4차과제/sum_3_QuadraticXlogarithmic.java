package Week_4_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class sum_3_QuadraticXlogarithmic {
	
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
		
		//step 2 : array[i] + array[j]을 0으로 만드는 수를 이진탐색을 통해 확인
		for(int i=0;i<arr_size;i++) {
			
			for(int j=i+1;j<arr_size;j++) {
				int key = -(array[i] + array[j]);
				int index = binarySearch(array, key);
				
				//탐색되면서, 같은 수끼리의 조합 제거후 갯수(count) 증가 
				if(index != -1 && array[i] != array[index] && array[j] != array[index]) {
					//조합 확인을 위한 print문
					System.out.println("("+array[i]+" "+array[j]+" "+array[index]+")");
					count++;
				}
			}
		}
		
		//3개의 순서 다른 조합이 있기 때문에 3을 나눠줌
		System.out.println("조합의 가능한 갯수는 : "+ count/3 +" 개 입니다.");
	}
	
	//이진 탐색
	private static int binarySearch(int[] array, int key) {
		
		int left = 0;
		int right = array.length-1;
		
		while(right >= left) {
			int mid = left + (right-left) / 2;
			
			if(key < array[mid]) right = mid-1;
			else if (key > array[mid]) left = mid+1;
			else return mid;
		}
		
		//탐색되지 않음
		return -1;
	}
}
