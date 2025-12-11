package Dec;

import java.util.Scanner;

public class Hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();

		String input = sc.next();

		char[] charArr = input.toCharArray();

		int hashValue = 31;

		int M = 1234567891;

		long result = 0;

		long powValue = 1;

		for (int i = 0; i < L; i++) {

			int charValue = (charArr[i] - 'a' + 1);

			result = (result + charValue * powValue) % M;

			powValue = (powValue * hashValue) % M;

		}
		System.out.println(result);

	}

}
