package Week_1_assignment;
public class fibonacci {
	static long[] arr = new long[90];
	
	public static long F(int N) {
		if(N==0) {
			arr[0] = 0;
			return 0;
		}
		if(N > 0 && N <= 2) {
			arr[1] = 1;
			arr[2] = 1;
			return 1;
		}
		
		if(arr[N] != 0) return arr[N];
		else{
			arr[N] = arr[N-1] + arr[N-2];
			return arr[N];
		}
	}
	public static void main(String[] args) {			
		for(int N=0;N<90;N++) {
			System.out.println(N+" "+F(N));
		}

	}
}
