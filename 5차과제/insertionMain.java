package Week_5_assignment;

public class insertionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arrayInteger = {1,6,4,3,7,8,2};
		String[] arrayString = {"a","k","f","e","g","s"};
		
		insertionSort s = new insertionSort();
		
		s.sort(arrayInteger);
		s.show(arrayInteger);
		
		s.sort(arrayString);
		s.show(arrayString);
	}

}
