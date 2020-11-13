package Week_11_assignment;

import java.util.Scanner;

public class baekjoon_12865_DPexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//���� ������ N ����(������ ��)
		int count = scan.nextInt();
		//���� ������ K ����(��ƿ �� �ִ� ����)
		int maxWeight = scan.nextInt();
		
		//������� DP���� �迭,����,��ġ ���� �迭
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
				//���� ���� ��ġ ����
				dp[i][j] = dp[i-1][j];
				//�ش� ���� ���԰� ���� �ִٸ� ���� ��ġ�� ���� ū ��ġ�� ����
				if(j-weight[i]>=0) {	
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}
		
		System.out.println(dp[count][maxWeight]);
	}
}
