package algo_251221;

import java.util.Scanner;

public class 영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		int ans = 0;
		
		for(int i = 0; i < 100000000; i++) {
			if(String.valueOf(i).contains("666")) {
				count++;
				
				if(N == count) {
					ans = i;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
