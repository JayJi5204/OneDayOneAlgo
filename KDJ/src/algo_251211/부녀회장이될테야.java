package algo_251211;

import java.util.Scanner;

public class 부녀회장이될테야 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] apt = new int[k+1][n+1];
			
			for(int j = 1; j <= n;j++) {
				apt[0][j] = j;
			}
			
			for(int x = 1; x <= k; x++) {
				for(int y = 1; y <= n; y++) {
					apt[x][y] = apt[x][y-1] + apt[x-1][y];
				}
			}
			
			int ans = apt[k][n];
			
			System.out.println(ans);
		}

	}

}
