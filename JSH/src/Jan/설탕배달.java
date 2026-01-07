package Jan;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int threeKG = 3;

		int count3 = 0;

		int result = 0;

		while (true) {
			if (N % 5 == 0) {
				break;
			}
			if (N < 0) {
				result = -1;
				break;
			}

			N = N - threeKG;
			count3++;

		}
		if (result == 0) {
			result = count3 + (N / 5);
			System.out.println(result);
		} else {
			System.out.println(result);
		}

	}
}
