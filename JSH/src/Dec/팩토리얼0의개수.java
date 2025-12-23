package Dec;

import java.util.Scanner;

public class 팩토리얼0의개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int value = N;

		int two = 0;

		int five = 0;

		while (true) {
			if (N == 0)
				break;

			if (value % 5 == 0) {
				value = value / 5;
				five++;
			}

			if (value % 2 == 0) {
				value = value / 2;
				two++;
			}

			if (value % 5 != 0 && value % 2 != 0) {

				N--;
				value = N;
			}

		}

//		System.out.println(two);
		System.out.println(five);

	}
}