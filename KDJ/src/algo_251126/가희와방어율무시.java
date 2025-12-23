package algo_251126;

import java.util.Scanner;

public class 가희와방어율무시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextInt();
		double b = sc.nextInt();
		
		int ans = 0;
		
		if(b == 0) {
			if(a <100) ans = 1;
		}else{
			if(a - (a/100*b) < 100) {
				ans = 1;
			}
		}
		System.out.println(ans);
	}
}
