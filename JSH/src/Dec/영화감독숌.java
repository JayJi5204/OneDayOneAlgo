package Dec;

import java.util.Scanner;

public class 영화감독숌 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int start = 665;

		int N = sc.nextInt();

		while (true) {

			start++;

			String strNumber = String.valueOf(start);
			if (strNumber.contains("666")) {
				N--;
			}

			if (N == 0)
				break;
		}
		
		System.out.println(start);

	}
}