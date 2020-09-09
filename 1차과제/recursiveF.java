package Week_1_assignment;
import java.util.Scanner;

public class recursiveF {
	static int[] arr;		//입력 배열 및 재귀로 갱신할 배열

	public static void main(String[] args) {
		int arrSize;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("배열의 크기를 설정해주세요");
		arrSize = scan.nextInt();		
		arr = new int[arrSize];
		
		System.out.println("배열에 값을 할당해주세요 배열의 크기는 "+arrSize+" 입니다.");
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

