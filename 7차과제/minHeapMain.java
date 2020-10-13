package Week_7_assignment;

import java.util.Scanner;

public class minHeapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		minHeap<Integer> heap = new minHeap<Integer>();
		
		System.out.println("배열에 넣을 숫자의 갯수를 입력해주세요.");
		int length = scan.nextInt();
		
		for(int i=0;i<length;i++) {
			System.out.println("배열에 넣을 숫자를 입력해주세요. 남은 숫자 :" + (length-i));
			int num = scan.nextInt();
			
			heap.insert(num);
		}
		
		System.out.println("현재 배열에 들어있는 숫자 나열입니다");
		heap.show();
		System.out.println();
		
		System.out.println("배열에서 삭제할 갯수를 입력해주세요");
		int delete = scan.nextInt();
		scan.close();
		
		for(int i=0;i<delete;i++) {
			heap.deleteMin();
		}
		
		System.out.println("삭제 후 남은 배열에 들어있는 숫자 나열입니다.");
		heap.show();
	}

}
