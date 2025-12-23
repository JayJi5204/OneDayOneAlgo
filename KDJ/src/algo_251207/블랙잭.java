package algo_251207;

import java.util.Scanner;

public class 블랙잭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int max = 0;
		
		int[] nums = new int[N];
		
		for(int i = 0; i<N;i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N-2;i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					
					if(sum <= M && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
