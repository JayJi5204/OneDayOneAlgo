package algo_251124;

import java.util.Scanner;

public class 중앙이동알고리즘 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = 2;

		int input = sc.nextInt();

		for (int i = 0; i < input; i++) {

			a = a + (a - 1);
		}

		System.out.println(a * a);

	}
}
