package algo_251205;

import java.util.Scanner;

public class 벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = 1;
		
		int layer = 1;
		int last = 1;
		
		for(int i = 0; i< N;i++) {
			if(N <= last) {
				System.out.println(layer);
				break;
			}else {
				last += 6*layer;
				layer++;
			}
		}
	}
}
