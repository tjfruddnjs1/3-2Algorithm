package Week_7_assignment;

import java.util.Scanner;

public class minHeapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		minHeap<Integer> heap = new minHeap<Integer>();
		
		System.out.println("�迭�� ���� ������ ������ �Է����ּ���.");
		int length = scan.nextInt();
		
		for(int i=0;i<length;i++) {
			System.out.println("�迭�� ���� ���ڸ� �Է����ּ���. ���� ���� :" + (length-i));
			int num = scan.nextInt();
			
			heap.insert(num);
		}
		
		System.out.println("���� �迭�� ����ִ� ���� �����Դϴ�");
		heap.show();
		System.out.println();
		
		System.out.println("�迭���� ������ ������ �Է����ּ���");
		int delete = scan.nextInt();
		scan.close();
		
		for(int i=0;i<delete;i++) {
			heap.deleteMin();
		}
		
		System.out.println("���� �� ���� �迭�� ����ִ� ���� �����Դϴ�.");
		heap.show();
	}

}
