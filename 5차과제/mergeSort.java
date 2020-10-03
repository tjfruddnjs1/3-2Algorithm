package Week_5_assignment;

public class mergeSort <T extends Comparable<T>> {
	
	//sort
	public void sort(T[] arr, T[] aux, int begin, int end) {
		//improvements 1 : 정렬해야될게 7개 이하인 경우 overhead를 줄이기 위한 삽입 정렬
		if(end-begin < 7) {
			insertionSort(arr,begin,end);
			return;
		}
		
		int mid = (begin + end) / 2;
		sort(arr,aux,begin,mid);
		sort(arr,aux,mid+1,end);
		
		//improvements 2 : 불필요한 재귀 호출 줄이기 위한 합병 조건 추가
		if(arr[mid].compareTo(arr[mid+1]) != 1) {
			return;
		}
		else {
			merge(arr,aux,begin,mid,end);
		}
	}
	
	//insertion sort
	private void insertionSort(T[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		int length =  arr.length;
		for(int i=1;i<length;i++) {
			for(int j=i;j>0 && less(arr[j], arr[j-1]);j--) {
				exch(arr, j, j-1);
			}
		}
	}
	
	//merge
	private void merge(T[] arr, T[] aux, int begin, int mid, int end) {
		
		for(int i=begin;i<=end;i++) {
			aux[i] = arr[i];
		}
		
		int l = begin, r=mid+1;
		for(int i=begin;i<=end;i++) {
			if(mid<1)								arr[i] = aux[r++];
			else if(end<r)							arr[i] = aux[l++];
			else if(aux[l].compareTo(aux[r])==-1) 	arr[i] = aux[l++];
			else									arr[i] = aux[r++];
		}
	}
	
	//두개의 double 값 비교 (return boolean) ,compareTo를 이용한
	private boolean less(T arr, T arr2) {
		return arr.compareTo(arr2) < 0;
	}
	
	//배열내의 두개의 값 교환, swap
	private void exch(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void show(Object[] a) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
