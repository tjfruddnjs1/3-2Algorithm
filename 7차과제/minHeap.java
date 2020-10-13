package Week_7_assignment;

public class minHeap<T extends Comparable<T>>{
	
	private T[] array = (T[]) new Comparable[1];
	private int tail = 0;
	
	//����
	public void insert(T e) {
		if(tail == array.length-1) resize(2*array.length);
		tail++;
		array[tail] = e;
		swim(tail);
	}
	
	//�迭 ũ�� ����
	private void resize(int max) {
		T[] temp = (T[]) new Comparable[max];
		
		for(int i=1;i<array.length;i++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	
	//����
	public T deleteMin() {
		T min = array[1];
		array[1] = array[tail--];
		sink(1);
		array[tail+1] = null;
		if(tail <= array.length/4) resize(array.length/2);
		return min;
	}
	
	//���� �� �迭 ����
	private void swim(int pos) {
		while(pos>1) {
			T child = array[pos];
			T parent = array[pos/2];
			if(less(parent, child)) break;
			else {
				exch(pos,pos/2);
				pos /= 2;
			}
		}
	}
	
	//��
	private boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	//��ȯ
	private void exch(int target1, int target2) {
		T temp = array[target1];
		array[target1] = array[target2];
		array[target2] = temp;
	}

	//���� �� �迭 ����
	private void sink(int pos) {
		while(2*pos <= tail) {
			int j = 2*pos;
			if(j<tail && !(less(array[j], array[j+1]))) j++;
			if(less(array[pos],array[j])) break;
			exch(pos,j);
			pos = j;
		}
	}
	
	//���
	public void show() {
		for(int i=1;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
	}
}
