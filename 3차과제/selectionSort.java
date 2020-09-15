package Week_3_assignment;

public class selectionSort extends Thread {
	double[] array;
	public selectionSort(double[] array){
		this.array = array;
	}
	
	@Override
	public void run() {
		System.out.println("선택 정렬 시작");
		long start = System.currentTimeMillis();
		for(int i=0;i<array.length;i++) {
			int min = i;
			for(int j=i+1;j<array.length;j++) {
				if(less(array[j], array[min])) min = j;
			}
			exch(array,i,min);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("selectionSort 수행시간 : " + (end-start) +" milliSecond 입니다.");
	}
	
	private boolean less(double target1, double target2) {
		boolean result;
		if(target1 < target2) result = true;
		else result = false;
		return result;
	}
	
	private void exch(double[] array, int i, int j) {
		double temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}