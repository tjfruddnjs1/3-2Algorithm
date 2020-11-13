package Week_11_assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1912_DPexample {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//입력을 위한 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		//입력받기 위한 배열
		int[] arr = new int[input];
		//DP를 위한 배열
		int[] dp = new int[input];
		
		for(int i=0;i<input;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		dp[0] = arr[0];
		int max = arr[0];
		//DP를 위한 반복문
		for(int i=1;i<input;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
