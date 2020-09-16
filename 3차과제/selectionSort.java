package Week_3_assignment;

public class selectionSort extends Thread {
	double[] array;
	public selectionSort(double[] array){
		this.array = array;
	}
	
	public void sort() {
	//selection sort �� ���� ���� �ð�
		System.out.println("���� ���� ����");
		long start = System.currentTimeMillis();
		for(int i=0;i<array.length;i++) {
			int min = i;
			for(int j=i+1;j<array.length;j++) {
				if(less(array[j], array[min])) min = j;
			}
			exch(array,i,min);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("selectionSort ����ð� : " + (end-start) +" milliSecond �Դϴ�.");
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