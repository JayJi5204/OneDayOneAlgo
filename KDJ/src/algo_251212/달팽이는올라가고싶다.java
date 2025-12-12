package algo_251212;

import java.util.Scanner;

public class 달팽이는올라가고싶다 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
//      시간초과남
//		int distance = 0;
//		int ans = 0;
//		
//		while(distance <= V) {
//			distance += A;
//			ans += 1;
//			
//			if(distance >= V) break;
//			
//			distance -= B;
//		}

		int ans = (V - A + (A - B) - 1)/(A - B) + 1;
		
		System.out.println(ans);
	}
}
