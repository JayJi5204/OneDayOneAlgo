package Nov;


import java.util.Scanner;

public class 세탁소사장동혁 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int max = sc.nextInt();

		for (int test_case = 0; test_case < max; test_case++) {

			int[] arr = new int[4];

			int input = sc.nextInt();

			int a = input / 25;

			arr[0] = a;

			int b = (input - 25 * a) / 10;

			arr[1] = b;

			int c = ((input - 25 * a) - 10 * b) / 5;

			arr[2] = c;

			int d = ((input - 25 * a) - 10 * b) - 5 * c;

			arr[3] = d;

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

	}
}

