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
		
		//1. 1~100 정수 배열 arr에 기억
		for(int i=0;i<arr.length;i++) 
			arr[i] = i+1;
		
		//2. shuffling 하여 배열 aux 기억
		Integer[] aux = shuffle(arr);
		
		quickSort<Integer> qselect = new quickSort<Integer>();
		
		//알고 싶은 하위 값 갯수 조정
		System.out.println("배열에서 하위 몇개의 값을 알고 싶은지 적어주세요.");
		Integer k = scan.nextInt();
		scan.close();
		Set<Integer> expected = new HashSet<Integer>();
		
		// assertions문을 위한 expected에 값 저장 및 값 출력
		while(k != 0) {
			Integer boundaryIndex = aux.length - k;
			System.out.println(qselect.quickSelect(aux, boundaryIndex));
			Collections.addAll(expected,boundaryIndex+1);
			k--;
		}
		
		// assertions문을 위한 actual에 값 저장
		Set<Integer> actual = new HashSet<Integer>();
		for(int i =aux.length-expected.size(); i<aux.length; i++) {
			Integer value = aux[i];
			if(aux.length-expected.size() <= value) {
				actual.add(value);
			}
		}
		
		// expected, actual 비교 
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
