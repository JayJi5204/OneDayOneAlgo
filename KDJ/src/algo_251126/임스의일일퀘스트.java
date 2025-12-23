package algo_251126;

import java.util.Scanner;

public class 임스의일일퀘스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int level = sc.nextInt();
		
		int arcane[] = {200, 210, 220, 225, 230, 235, 245, 250};
		
		int ans[] = new int[13];
		
		if(level < 260) {
			for(int i =0; i <6; i++) {
				if(arcane[i+2] <= level) {
					ans[i] = 100;
				}else if(arcane[i+1] <= level) {
					ans[i] = 300;
				}else if(arcane[i] <= level) {
					ans[i] = 500;
				}
			}
		}
		
		if(level >= 260 && level < 295) {
			int grandis = level/5-46;
			
			ans[grandis] = 500;
			
			if(grandis-1 >5) {
				ans[grandis-1] = 300;
			}else ans[grandis-1] = 100;
			
			for(int i = grandis-2; i >= 0; i--) {
				ans[i] = 100;
			}
		}
		
		if(level >= 295 && level <300 ) {
			ans[12] = 300;
			for(int i = 11; i >= 0; i--) {
				ans[i] = 100;
			}
		}
		
		if(level == 300) {
			for(int i = 12; i >= 0; i--) {
				ans[i] = 100;
			}
		}
		
		for(int i =0; i<13; i++) {
			if(i == 6) {
				System.out.println();
			}
			System.out.print(ans[i]+" ");
		}
	}
}
