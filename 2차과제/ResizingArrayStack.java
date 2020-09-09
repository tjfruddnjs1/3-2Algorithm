package Week_2_assignment;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
	
	//여러 타입을 고려한 generic type
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	//resize > 배열의 크기를 재설정하기위한 
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for(int i=0;i<N;i++) { 
			temp[i] = a[i];
		}
		
		a=temp;
		
	}
	
	//N이 배열의 2/3정도 되었을때 배열의 크기를 2배로
	public void push(Item item) {
		if(N >= (a.length/3)*2) {
			resize(2*a.length);
			System.out.println("배열의 크기를 고려하여 resize 되었습니다 [배열의 크기 : "+ a.length +"]");
		}
		a[N++] = item;
	}
	
	//배열이 전체의 1/4정도밖에 사용하지 않는다면 배열의 크기를 1/2배로
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N <= a.length/4) {
			resize(a.length/2);
			System.out.println("배열의 크기를 고려하여 resize 되었습니다 [배열의 크기 : "+ a.length +"]");
		}
		return item;
	}
	
	//Iterator 재정의 > 역순으로 값을 가져오기 위해
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i =N;
		public boolean hasNext() {
			return i>0;
		}
		public Item next() {
			return a[--i];
		}
		public void remove() {
			
		}
	}
	
}
