package Jan;

import java.util.Scanner;

public class 동전0 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] money = new int[N];

		for (int i = 0; i < N; i++) {
			money[i] = sc.nextInt();

		}

		int result = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (money[i] <= K) {

				while (true) {
					if (K == 0) {
						break;
					}

					if (K < money[i]) {
						break;
					}

					K = K - money[i];
					result++;

				}
			}
		}

		System.out.println(result);

	}
}