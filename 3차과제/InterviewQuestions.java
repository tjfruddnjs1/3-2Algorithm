package Week_3_assignment;

import java.util.Scanner;
import java.util.Stack;

public class InterviewQuestions{
	
	//�ΰ��� ������ �̿��Ͽ� ť�� ����� ����
	static Stack<String> stack = new Stack<String>(); 
	static Stack<String> stackForQ = new Stack<String>();  
	
	static boolean offloop = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		while(offloop){
			String command = scan.next();
			String item;
			switch(command) {
				case "enQ" :
					item = scan.next();
					Enqueue(item);
					break;
				
				case "deQ" :
					System.out.println(Dequeue());
					break;
				
				case "size" :
					System.out.println(size());
					break;
					
				case "Qsize":
					System.out.println(Qsize());
					break;
					
				case "exit" : 
					offloop = false;
					break;
				
				default :
					System.out.println("�߸��� ��ɾ� �Դϴ�.");
					break;
			}
		}
		
		scan.close();
		
	}
	
	private static void Enqueue(String data) {
		
		/* 
		 * �ѹ� DeQueue()����� �����ϰ�, �ٽ� Enqueue()����� �����ϱ� ����
		 * stack�� ����ְ�, stackForQ�� ������� ���� ��� ���  
		 */
		if(!stackForQ.isEmpty() && stack.isEmpty()) {
			while(true) {
				stack.push(stackForQ.pop());
	
				if(stackForQ.isEmpty()) {
					stack.push(data);
					break;
				}
			}
		}else{
		/* 
		 * �Ϲ����� ���
		 */
			stack.push(data);
		}
	}
	
	private static String Dequeue() {
		
		String data;
		
		/*
		 * DeQueue����� �����ؼ� �����ϴ� ���(�̹� stackForQ�� pop ������ ��Ұ� �ִ� ���) ���
		 */
		if(stackForQ.isEmpty()) {
			
			while(true) {
			stackForQ.push(stack.pop());
			
			if(stack.isEmpty())
				break;
			}
		}
		
		data = stackForQ.pop();
		
		return data;
	}
	
	//�߰��߰� �ذ��ϱ� ���� debug�� ���� size
	private static int size() {
		return stack.size();
	}
	
	private static int Qsize() {
		return stackForQ.size();
	}
}
