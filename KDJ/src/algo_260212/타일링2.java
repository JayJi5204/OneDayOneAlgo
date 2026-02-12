package algo_260212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		dp[4] = 11;
		
		for(int i = 5; i <= N; i++) {
			dp[i] = (2*dp[i-2] + dp[i-1])%10007;
		}
		System.out.println(dp[N]);
	}
}