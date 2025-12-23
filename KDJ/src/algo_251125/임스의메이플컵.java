package algo_251125;

import java.util.Scanner;

public class 임스의메이플컵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int U = sc.nextInt();
		int L = sc.nextInt();
		
		String result = "Bad";
		
		if(N >= 1000) {
			result = "Good";
			
			if(U >= 8000 || L >= 260) {
				result = "Very Good";
			}
		}
	System.out.println(result);	
	}

}
