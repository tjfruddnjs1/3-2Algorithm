package Week_11_assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1912_DPexample {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//�Է��� ���� BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		//�Է¹ޱ� ���� �迭
		int[] arr = new int[input];
		//DP�� ���� �迭
		int[] dp = new int[input];
		
		for(int i=0;i<input;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		dp[0] = arr[0];
		int max = arr[0];
		//DP�� ���� �ݺ���
		for(int i=1;i<input;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
