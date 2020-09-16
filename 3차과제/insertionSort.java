package Week_3_assignment;

public class insertionSort {
	double[] array;
	
	public insertionSort(double[] array) {
		this.array = array;
	}

	public void sort() {
	//insertion sort 및 정렬 수행 시간
		System.out.println("삽입 정렬 시작");
		long start = System.currentTimeMillis();
		for(int i=1;i<array.length;i++) {
			for(int j=i;j>0 && less(array[j], array[j-1]);j--) {
				exch(array, j, j-1);
			}
		}
		long end = System.currentTimeMillis();
		
		System.out.println("insertionSort 수행시간 : " + (end-start) +" milliSecond 입니다.");
		System.out.println("삽입 정렬 종료");
	}
	
	//두개의 double 값 비교 (return boolean)
	private boolean less(double target1, double target2) {
		boolean result;
		if(target1 < target2) result = true;
		else result = false;
		return result;
	}
	//배열내의 두개의 값 교환
	private void exch(double[] array, int i, int j) {
		double temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
