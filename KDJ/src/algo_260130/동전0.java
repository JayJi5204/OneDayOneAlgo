package algo_260130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		
		for(int i = N-1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		
		int sum = 0;
		int place = 0;
		
		while(true) {
							
			if(sum == K) {
				System.out.println(cnt);
				break;
			}
			
			sum+= coins[place];
			cnt++;
			
			if( sum > K) {
				cnt--;
				sum -= coins[place];
				place++;
			}
		}
	}
}