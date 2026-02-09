package algo_260209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
	
		long[] dp = new long[101];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		for(int i = 5; i <= 100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			int input = Integer.parseInt(br.readLine());
			
			sb.append(dp[input]).append('\n');
			
		}
		System.out.println(sb);
	}
}