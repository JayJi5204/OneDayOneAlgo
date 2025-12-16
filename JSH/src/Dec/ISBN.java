package Dec;

import java.util.Scanner;

public class ISBN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String stringValue = sc.next();

		char[] arr = stringValue.toCharArray();

		int plusValue = 0;

		int arrCount = 0;

		for (int i = 0; i < arr.length; i++) {
			int arrValue = 1;
			if (arr[i] == '*') {
				arrCount = i;
				continue;
			}
			if (i % 2 != 0) {
				arrValue = 3 * (arr[i] - '0');
			} else {
				arrValue = arr[i] - '0';
			}
			plusValue = plusValue + arrValue;

		}
		int result = 0;

		if (arrCount % 2 == 0) {

			result = plusValue % 10;

			result = 10 - result;

		} else {

			for (int i = result; i < 10; i++) {
				if ((plusValue + 3 * i) % 10 == 0) {
					result = i;
					break;
				}

			}
		}

		System.out.println(result);

	}
}