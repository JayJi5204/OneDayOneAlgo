package Dec;

import java.util.Scanner;

public class 최대공약수와최소공배수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int input1 = sc.nextInt();
		int[] input1Arr = new int[input1 + 1];

		int input2 = sc.nextInt();
		int[] input2Arr = new int[input2 + 1];

		int count = 2;

		int length = 0;

		int[] secondArr;

		if (input1Arr.length < input2Arr.length) {
			length = input1Arr.length - 1;
			secondArr = input2Arr;
		} else {
			length = input2Arr.length - 1;
			secondArr = input1Arr;
		}

		if (input1 == 1) {
			System.out.println(input1);
			System.out.println(input2);
		} else if (input2 == 1) {
			System.out.println(input2);
			System.out.println(input1);

		} else {
			arrCount(length, 2, input1, input1Arr);
			arrCount(length, 2, input2, input2Arr);

//			for (int i = 0; i < input2Arr.length; i++) {
//				System.out.println(input2Arr[i]);
//			}
//			System.out.println("-------------");

			firstResult(length, input1Arr, input2Arr);
			secondResult(length, secondArr);
		}

	}

	public static void arrCount(int length, int count, int input, int[] inputArr) {
		while (true) {

			if (input == 1) {
				break;
			}

			if (input % count == 0) {
				input = input / count;
				inputArr[count]++;
			} else {
				count++;
			}

		}

	}

	public static void firstResult(int length, int[] input1Arr, int[] input2Arr) {
		int check = 1;
		int result = 1;

		while (true) {

			if (length < check)
				break;

			if (input1Arr[check] != 0 && input2Arr[check] != 0) {
				result = result * check;
				input1Arr[check]--;
				input2Arr[check]--;
			} else {
				check++;
			}
		}

		System.out.println(result);
	}

	public static void secondResult(int length, int[] inputArr) {
		int check = 2;
		int result = length;

		while (true) {

			if (inputArr.length == check)
				break;
			if (inputArr[check] != 0) {
				result = result * check;
				inputArr[check]--;
			} else {
				check++;
			}
		}
		System.out.println(result);
	}
}