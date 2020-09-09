package Week_2_assignment;

import java.util.Iterator;
import java.util.Scanner;

public class ResizeStackMain {

	public static boolean offLoop = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		
		while(offLoop) {
			String stackController = scan.next();
			String stackElement;
			
			switch(stackController) {
				case "push":
					stackElement = scan.next();
					stack.push(stackElement);
					break;
					
				case "pop":
					System.out.println(stack.pop());
					break;
					
				case "iterate":
					Iterator<String> it = stack.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					break;
					
				case "exit":
					offLoop = false;
					break;
					
				default:
					System.out.println("잘못된 명령어 입니다.");
					break;
			}
		}
		
		scan.close();
	}

}
