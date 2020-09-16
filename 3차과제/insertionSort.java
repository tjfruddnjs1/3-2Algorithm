package Week_3_assignment;

public class insertionSort {
	double[] array;
	
	public insertionSort(double[] array) {
		this.array = array;
	}

	public void sort() {
	//insertion sort �� ���� ���� �ð�
		System.out.println("���� ���� ����");
		long start = System.currentTimeMillis();
		for(int i=1;i<array.length;i++) {
			for(int j=i;j>0 && less(array[j], array[j-1]);j--) {
				exch(array, j, j-1);
			}
		}
		long end = System.currentTimeMillis();
		
		System.out.println("insertionSort ����ð� : " + (end-start) +" milliSecond �Դϴ�.");
		System.out.println("���� ���� ����");
	}
	
	//�ΰ��� double �� �� (return boolean)
	private boolean less(double target1, double target2) {
		boolean result;
		if(target1 < target2) result = true;
		else result = false;
		return result;
	}
	//�迭���� �ΰ��� �� ��ȯ
	private void exch(double[] array, int i, int j) {
		double temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
