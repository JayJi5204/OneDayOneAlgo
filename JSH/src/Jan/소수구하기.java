package Jan;

import java.util.Scanner;

public class 소수구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] check = new boolean[N + 1];

		for (int i = 2; i < check.length; i++) {
			check[i] = true;

		}

		for (int i = 2; i * i <= N; i++) {
			if (check[i] == false) {
				continue;
			}

			for (int j = i * i; j <= N; j += i) {
				check[j] = false;

			}

		}

		for (int i = M; i <= N; i++) {
			if (check[i]) {
				System.out.println(i);
			}

		}

	}
}