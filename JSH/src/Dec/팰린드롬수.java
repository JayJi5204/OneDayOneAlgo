package Dec;

import java.util.Scanner;

public class 팰린드롬수 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {

			String result = "";

			String input = sc.next();

			if (input.equals("0"))
				break;

			char[] charArr = input.toCharArray();

			if (charArr.length == 1)
				result = "yes";

			for (int i = 0; i < charArr.length / 2; i++) {

//				System.out.println(charArr[i] + " vs " + charArr[charArr.length - i - 1]);

				if (charArr[i] == charArr[charArr.length - i - 1]) {

					result = "yes";
				} else {
					result = "no";
					break;
				}

			}

			System.out.println(result);

		}

	}

}
