package Jan;

import java.util.Scanner;

public class 체스판_다시_칠하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = sc.next();

			arr[i] = input.toCharArray();
		}

		int result = 100000000;

		for (int outI = 0; outI < N - 7; outI++) {
			for (int outJ = 0; outJ < M - 7; outJ++) {

				int count = 0;

				for (int i = outI; i < outI + 8; i++) {
					for (int j = outJ; j < outJ + 8; j++) {
						char word;

						if ((i + j) % 2 == 0) {
							word = 'W';
						} else {
							word = 'B';
						}

						if (arr[i][j] != word) {
							count++;
						}

					}

				}
				int minCount = Math.min(count, 64 - count);

				result = Math.min(minCount, result);

			}
		}
		System.out.println(result);

	}
}