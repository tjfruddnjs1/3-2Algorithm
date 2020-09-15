package Week_3_assignment;

import java.util.Scanner;
import java.util.Stack;

public class InterviewQuestions{
	
	//두개의 스택을 이용하여 큐의 기능을 구현
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
					System.out.println("잘못된 명령어 입니다.");
					break;
			}
		}
		
		scan.close();
		
	}
	
	private static void Enqueue(String data) {
		
		/* 
		 * 한번 DeQueue()명령을 실행하고, 다시 Enqueue()명령을 실행하기 위해
		 * stack이 비어있고, stackForQ가 비어있지 않은 경우 고려  
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
		 * 일반적인 경우
		 */
			stack.push(data);
		}
	}
	
	private static String Dequeue() {
		
		String data;
		
		/*
		 * DeQueue명령을 연속해서 실행하는 경우(이미 stackForQ에 pop 가능한 요소가 있는 경우) 고려
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
	
	//중간중간 해결하기 위해 debug를 위한 size
	private static int size() {
		return stack.size();
	}
	
	private static int Qsize() {
		return stackForQ.size();
	}
}
