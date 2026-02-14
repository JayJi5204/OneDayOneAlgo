package algo_260213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FourSquares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
        
		Arrays.fill(dp, 4); 
        dp[0] = 0;

        int max = (int)Math.sqrt(N);
        int[] sq = new int[max + 1];
        for (int i = 1; i <= max; i++) sq[i] = i * i;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= max; j++) {
                int s = sq[j];
                if (s > i) break;
                dp[i] = Math.min(dp[i], dp[i - s] + 1);
                if (dp[i] == 1) break; 
            }
        }
        System.out.println(dp[N]);
    }
}