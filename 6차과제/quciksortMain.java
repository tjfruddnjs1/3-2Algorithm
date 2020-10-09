package Week_6_assignment;

import StdRandom.StdRandom;

public class quciksortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "K,A,R,T,E,L,E,P,U,I,M,Q,C,X,O,S";
		String[] array = str.split(",");
		shuffle(array);
		
		quickSort<String> qsort = new quickSort<String>();
		qsort.quickSort(array, 0, array.length-1);
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	//shuffle
	public static void shuffle(Object[] array) {
			int N = array.length;
			for(int i=0;i<N;i++) {
				int r = StdRandom.uniform(i+1);
				Object tmp = array[i];
				array[i] = array[r];
				array[r] = tmp;
		}
	}
}
