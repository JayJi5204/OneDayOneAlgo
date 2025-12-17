package Dec;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String[] arr = new String[3];

		int intValue = 0;
		int arrNumber = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals("Fizz") && !arr[i].equals("Buzz") && !arr[i].equals("FizzBuzz")) {
				intValue = Integer.parseInt(arr[i]);
				arrNumber = i;
				break;
			}
		}

		if (arrNumber == 0) {

			intValue = intValue + 3;

		} else if (arrNumber == 1) {

			intValue = intValue + 2;

		} else if (arrNumber == 2) {

			intValue = intValue + 1;

		}

		if (intValue % 3 == 0 && intValue % 5 == 0) {

			System.out.println("FizzBuzz");

		} else if (intValue % 3 == 0 && intValue % 5 != 0) {

			System.out.println("Fizz");

		} else if (intValue % 3 != 0 && intValue % 5 == 0) {

			System.out.println("Buzz");

		} else {

			System.out.println(intValue);

		}

	}
}