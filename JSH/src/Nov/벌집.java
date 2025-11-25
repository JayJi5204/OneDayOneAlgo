package Nov;

import java.util.Scanner;

public class 벌집 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean check = true;

		int input = sc.nextInt();

		int a = 0;

		int b = 1;

		while (check) {

			b = 6 * a + b;

			if (input <= b)
				check = false;

			a++;

		}

		System.out.println(a);

	}

}
