package Week_5_assignment;

public class mergeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arrayInteger = {1,6,4,3,7,8,2};
		int length = arrayInteger.length;
		Integer[] auxInteger = new Integer[length];
		
		String[] arrayString = {"a","k","f","e","g","s"};
		int lengthString = arrayString.length;
		String[] auxString = new String[lengthString];
		
		mergeSort s = new mergeSort();
		
		s.sort(arrayInteger, auxInteger, 0, length-1);
		s.show(arrayInteger);
		
		s.sort(arrayString, auxString, 0, lengthString-1);
		s.show(arrayString);
	}

}
