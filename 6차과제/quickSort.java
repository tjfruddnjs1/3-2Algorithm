package Week_6_assignment;

public class quickSort <T extends Comparable<T>>{
	//Using insertion sort in 7 sub arrays
	public static int CUTOFF = 7;
	
	//quickSort
	public void quickSort(T[] array, int lo, int hi) {
		
		if(hi <= lo + CUTOFF - 1) {
			insertionSort(array,lo,hi);
			return;
		}
		
		int j = partition(array,lo,hi);
		quickSort(array,lo,j-1);
		quickSort(array,j+1,hi);
	}
	
	//insertionSort
	private void insertionSort(T[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		int length =  arr.length;
		for(int i=begin;i<end;i++) {
			for(int j=i;j>0 && less(arr[j], arr[j-1]);j--) {
				exch(arr, j, j-1);
			}
		}
	}

	//quickSelect > partition�� �̿���
	public T quickSelect(T[] array, int index) {
		int lo=0, hi=array.length-1;
		while(hi>lo) {
			int j= partition(array,lo,hi);
			if		(j<index) lo = j+1;
			else if (j>index) hi = j-1;
			else	return array[index];
		}
		return array[index];
	}
	
	//partition ���ϱ�, a[]�� a[lo,,j-1], a[j], a[j+1,,hi]�� �����ϰ� j return
	private int partition(T[] array, int lo, int hi) {
		int i = lo, j = hi+1; 	//�¿������� ��ĵ�� ���� index
		T v = array[lo];		//���� ���� �׸�
		
		while(true) {
			//�¿������� ���� ��ĵ�ϸ鼭 �Ϸ� ���θ� Ȯ���ϰ� ��ȯ
			while(less(array[++i],v)) if(i==hi) break;
			while(less(v,array[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(array,i,j);
		}
		//���� ���� �׸� v�� a[j]�� �ִ´�
		exch(array,lo,j);
		//a[lo,,j-1] <= a[j] <= a[j+1,hi] ���踦 ����
		return j;
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
}
