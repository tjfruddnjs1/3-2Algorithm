package Week_5_assignment;

public class insertionSort<T extends Comparable<T>> {
	
	//���� ����, assert �� check �ϱ� ����
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
	
	//�ΰ��� double �� �� (return boolean) ,compareTo�� �̿���
	private boolean less(T target1, T target2) {
		return target1.compareTo(target2) < 0;
	}
	
	//�迭���� �ΰ��� �� ��ȯ, swap
	private void exch(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//���ĵǾ��ִ��� Ȯ�� �ϱ� ����
	private boolean isSorted(T[] a) {
		return isSorted(a, 0, a.length -1);
	}
	
	private boolean isSorted(T[] a, int low, int high) {
		for(int i= low+1;i<=high;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	//�迭�� ���� ��� ���
	public void show(Object[] a) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
