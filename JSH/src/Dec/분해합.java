package Dec;

import java.util.Scanner;

public class 분해합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		int checkValue = 0;

		int result = 0;

		boolean check = true;

		int intValue = input;

		while (check) {
			checkValue = 0;

			String stringValue = String.valueOf(intValue);
//			System.out.println(intValue);

			char[] charArr = stringValue.toCharArray();

			int[] intArr = new int[charArr.length];

			for (int i = 0; i < charArr.length; i++) {
				intArr[i] = charArr[i] - '0';
//				System.out.println(intArr[i]);
				checkValue = checkValue + intArr[i];
			}
//			System.out.println(checkValue);

			if (intValue + checkValue == input)
				result = intValue;
			intValue--;
			if (intValue == 0) {
				break;
			}

		}

		System.out.println(result);

	}

}
