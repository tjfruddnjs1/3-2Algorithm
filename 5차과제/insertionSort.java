package Week_5_assignment;

public class insertionSort<T extends Comparable<T>> {
	
	//삽입 정렬, assert ← check 하기 위한
	public void sort(T[] array) {
		int length =  array.length;
		for(int i=1;i<length;i++) {
			for(int j=i;j>0 && less(array[j], array[j-1]);j--) {
				exch(array, j, j-1);
				assert isSorted(array,0,i);
			}
			assert isSorted(array);
		}
	}
	
	//두개의 double 값 비교 (return boolean) ,compareTo를 이용한
	private boolean less(T target1, T target2) {
		return target1.compareTo(target2) < 0;
	}
	
	//배열내의 두개의 값 교환, swap
	private void exch(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//정렬되어있는지 확인 하기 위한
	private boolean isSorted(T[] a) {
		return isSorted(a, 0, a.length -1);
	}
	
	private boolean isSorted(T[] a, int low, int high) {
		for(int i= low+1;i<=high;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	//배열의 원소 모두 출력
	public void show(Object[] a) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
