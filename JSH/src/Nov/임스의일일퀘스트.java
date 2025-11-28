package Nov;

import java.util.Scanner;

public class 임스의일일퀘스트 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		int[] arr1 = new int[3];
		int[] arr2 = new int[3];
		int[] arr3 = new int[9];

		int arr1Value = 200;
		int arr2Value = 225;
		int arr3Value = 260;

		int a = (input - arr1Value) / 5;
		int b = (input - arr2Value) / 5;
		int c = (input - arr3Value) / 5;

		extracted1(arr1, a);
		extracted2(arr2, b);
		extracted3(arr3, c);

		if (220 < input && input < 225) {
			arr2[0] = 0;
		}

		if (input < 260) {
			arr3[0] = 0;
		}

		for (int i = 0; i < 3; i++) {
			System.out.print(arr1[i] + " ");
		}

		for (int i = 0; i < 3; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < 7; i++) {
			System.out.print(arr3[i] + " ");
		}

	}

	private static void extracted1(int[] arr1, int a) {
		if (6 <= a) {
			arr1[0] = 100;
			arr1[1] = 100;
			arr1[2] = 100;
		}

		if (a == 5) {
			arr1[0] = 100;
			arr1[1] = 100;
			arr1[2] = 300;
		}
		if (a == 4) {
			arr1[0] = 100;
			arr1[1] = 300;
			arr1[2] = 500;
		}
		if (a == 3) {
			arr1[0] = 300;
			arr1[1] = 500;
		}
		if (a == 2) {
			arr1[0] = 300;
			arr1[1] = 500;
		}
		if (a == 1) {
			arr1[0] = 500;
		}
		if (a == 0) {
			arr1[0] = 500;
		}
	}

	private static void extracted2(int[] arr2, int b) {
		if (5 <= b) {
			arr2[0] = 100;
			arr2[1] = 100;
			arr2[2] = 100;
		}
		if (b == 4) {
			arr2[0] = 100;
			arr2[1] = 100;
			arr2[2] = 300;
		}
		if (b == 3) {
			arr2[0] = 100;
			arr2[1] = 300;
			arr2[2] = 500;
		}
		if (b == 2) {
			arr2[0] = 100;
			arr2[1] = 300;
			arr2[2] = 500;
		}
		if (b == 1) {
			arr2[0] = 300;
			arr2[1] = 500;
		}
		if (b == 0) {
			arr2[0] = 500;
		}
	}

	private static void extracted3(int[] arr2, int c) {
		if (0 == c) {
			arr2[c] = 500;
		}

		if (c == 1) {
			arr2[c - 1] = 300;
			arr2[c] = 500;
		}
		if (c == 2) {
			arr2[c - 2] = 100;
			arr2[c - 1] = 300;
			arr2[c] = 500;
		}
		if (3 <= c) {

			for (int i = 0; i < c - 1; i++) {
				arr2[i] = 100;

			}

			arr2[c - 1] = 300;
			arr2[c] = 500;
		}
	}

}
