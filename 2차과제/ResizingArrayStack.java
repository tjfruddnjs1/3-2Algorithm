package Week_2_assignment;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
	
	//���� Ÿ���� ����� generic type
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	//resize > �迭�� ũ�⸦ �缳���ϱ����� 
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for(int i=0;i<N;i++) { 
			temp[i] = a[i];
		}
		
		a=temp;
		
	}
	
	//N�� �迭�� 2/3���� �Ǿ����� �迭�� ũ�⸦ 2���
	public void push(Item item) {
		if(N >= (a.length/3)*2) {
			resize(2*a.length);
			System.out.println("�迭�� ũ�⸦ ����Ͽ� resize �Ǿ����ϴ� [�迭�� ũ�� : "+ a.length +"]");
		}
		a[N++] = item;
	}
	
	//�迭�� ��ü�� 1/4�����ۿ� ������� �ʴ´ٸ� �迭�� ũ�⸦ 1/2���
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N <= a.length/4) {
			resize(a.length/2);
			System.out.println("�迭�� ũ�⸦ ����Ͽ� resize �Ǿ����ϴ� [�迭�� ũ�� : "+ a.length +"]");
		}
		return item;
	}
	
	//Iterator ������ > �������� ���� �������� ����
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
