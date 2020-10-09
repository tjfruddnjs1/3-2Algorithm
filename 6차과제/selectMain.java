package Week_6_assignment;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

import StdRandom.StdRandom;

public class selectMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Integer[] arr = new Integer[100];
		
		//1. 1~100 ���� �迭 arr�� ���
		for(int i=0;i<arr.length;i++) 
			arr[i] = i+1;
		
		//2. shuffling �Ͽ� �迭 aux ���
		Integer[] aux = shuffle(arr);
		
		quickSort<Integer> qselect = new quickSort<Integer>();
		
		//�˰� ���� ���� �� ���� ����
		System.out.println("�迭���� ���� ��� ���� �˰� ������ �����ּ���.");
		Integer k = scan.nextInt();
		scan.close();
		Set<Integer> expected = new HashSet<Integer>();
		
		// assertions���� ���� expected�� �� ���� �� �� ���
		while(k != 0) {
			Integer boundaryIndex = aux.length - k;
			System.out.println(qselect.quickSelect(aux, boundaryIndex));
			Collections.addAll(expected,boundaryIndex+1);
			k--;
		}
		
		// assertions���� ���� actual�� �� ����
		Set<Integer> actual = new HashSet<Integer>();
		for(int i =aux.length-expected.size(); i<aux.length; i++) {
			Integer value = aux[i];
			if(aux.length-expected.size() <= value) {
				actual.add(value);
			}
		}
		
		// expected, actual �� 
		Assertions.assertEquals(expected, actual);
	}
	
	//shuffle
	public static Integer[] shuffle(Integer[] array) {
			int N = array.length;
			for(int i=0;i<N;i++) {
				int r = StdRandom.uniform(i+1);
				int tmp = array[i];
				array[i] = array[r];
				array[r] = tmp;
		}
			return array;
	}
}
