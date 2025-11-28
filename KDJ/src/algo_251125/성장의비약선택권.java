package algo_251125;

import java.util.Scanner;

public class 성장의비약선택권 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int level = sc.nextInt();
		
		int ans = 0;
		
		if(level >=200 && level < 206) {
			ans = 1;
		}else if(level >=206 && level < 218) {
			ans = 2;
		}else if(level >=218 && level < 229) {
			ans = 3;
		}else ans = 4;
		
		System.out.println(ans);
	}
}
