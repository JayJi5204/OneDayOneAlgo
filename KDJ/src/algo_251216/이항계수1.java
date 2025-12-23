package algo_251216;

import java.util.Scanner;

public class 이항계수1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int ans = 1;
		
		for(int i = 0; i < K; i++) {
			ans *= (N-i);
		}
		
		for(int i = 1; i <= K; i++) {
			ans /= i;
		}

		System.out.println(ans);
	}
}
