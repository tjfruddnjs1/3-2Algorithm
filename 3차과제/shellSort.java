package Week_3_assignment;

public class shellSort{
	double[] array;
	public shellSort(double[] array){
		this.array = array;
	}
	
	public void sort() {
	//shell sort �� ���� ���� �ð�
		System.out.println("�� ���� ����");
		int h = 1;
		long start = System.currentTimeMillis();
		while(h<array.length/3) h = 3*h+1;
		
		while(h>=1) {
			for(int i =h;i<array.length;i++) {
				for(int j=i; j>=h && less(array[j],array[j-h]);j-=h) {
					exch(array,j,j-h);
				}
			}
			h /= 3;
		}
		long end = System.currentTimeMillis();
		System.out.println("shellsort ����ð� : " + (end-start) +" milliSecond �Դϴ�.");
		System.out.println("�� ���� ����");
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