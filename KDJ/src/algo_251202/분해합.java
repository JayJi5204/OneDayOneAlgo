package algo_251202;

import java.util.Scanner;

public class 분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int M = Integer.parseInt(N);
		
		int ans = 0;
		
		for(int i = 0; i < M; i++) {
			
			String num = String.valueOf(i);
			int L = num.length();
			
			int sum = i;
			
			for(int j = 0; j < L; j++) {
				sum += num.charAt(j) - '0';
			}
			
			if(sum == M) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
