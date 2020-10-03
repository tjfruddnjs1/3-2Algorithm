package Week_5_assignment;

public class mergeSort <T extends Comparable<T>> {
	
	//sort
	public void sort(T[] arr, T[] aux, int begin, int end) {
		//improvements 1 : �����ؾߵɰ� 7�� ������ ��� overhead�� ���̱� ���� ���� ����
		if(end-begin < 7) {
			insertionSort(arr,begin,end);
			return;
		}
		
		int mid = (begin + end) / 2;
		sort(arr,aux,begin,mid);
		sort(arr,aux,mid+1,end);
		
		//improvements 2 : ���ʿ��� ��� ȣ�� ���̱� ���� �պ� ���� �߰�
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
	
	//�ΰ��� double �� �� (return boolean) ,compareTo�� �̿���
	private boolean less(T arr, T arr2) {
		return arr.compareTo(arr2) < 0;
	}
	
	//�迭���� �ΰ��� �� ��ȯ, swap
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
