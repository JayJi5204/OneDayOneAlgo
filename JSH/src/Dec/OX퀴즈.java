package Dec;

import java.util.Scanner;

public class OX퀴즈 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 0; i < testCase; i++) {

			String quizResult = sc.next();

			char[] arr = quizResult.toCharArray();

			int result = 0;

			int O = 1;

			for (int j = 0; j < arr.length; j++) {

//				System.out.println("j: " + j);

				if (arr[j] == 'O') {
					result = result + O;
					O++;
//					System.out.println("result: " + result);
				} else {
					O = 1;
//					System.out.println("result: " + result);
				}

			}

			System.out.println(result);

		}

	}

}