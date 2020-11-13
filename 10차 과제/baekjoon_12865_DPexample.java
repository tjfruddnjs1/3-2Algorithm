package Week_11_assignment;

import java.util.Scanner;

public class baekjoon_12865_DPexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//문제 에서의 N 역할(물건의 수)
		int count = scan.nextInt();
		//문제 에서의 K 역할(버틸 수 있는 무게)
		int maxWeight = scan.nextInt();
		
		//순서대로 DP위한 배열,무게,가치 저장 배열
		int[][] dp = new int[count+1][maxWeight+1];
		int[] weight = new int[count+1];
		int[] value = new int[count+1];

		for (int i = 1; i <= count; i++) {
			weight[i] = scan.nextInt();
			value[i] = scan.nextInt();
		}
		
		scan.close();

		for (int i=1;i<=count;i++) {
			for(int j=1;j<=maxWeight;j++) {
				//이전 물건 가치 저장
				dp[i][j] = dp[i-1][j];
				//해당 물건 무게가 담길수 있다면 이전 가치와 비교해 큰 가치값 저장
				if(j-weight[i]>=0) {	
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}
		
		System.out.println(dp[count][maxWeight]);
	}
}
