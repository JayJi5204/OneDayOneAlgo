package algo_251210;

import java.util.Scanner;

public class 최대공약수와최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int gcd =  GCD(A, B);
		int lcm = A*B/gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
	
	public static int GCD(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}
