package algo_251124;

import java.util.Scanner;

public class 소수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			
			boolean prime = true;
			
			if(num == 1) continue;
			
			for(int j = 2; j<num; j++) {				
				if(num%j == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime) cnt++;
			
		}
		System.out.println(cnt);

	}

}
