package Dec;

import java.util.Scanner;

public class ACM호텔 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test = 0; test < T; test++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			boolean[][] arr = new boolean[H][W];

			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {

					if (N == 0) {
						break;
					}

					arr[j][i] = true;
					N = N - 1;

				}
				if (N == 0) {
					break;
				}

			}

			int X = 0;
			int Y = 0;

			for (int i = 0; i < W; i++) {

				for (int j = 0; j < H; j++) {

					if (arr[j][i] == false) {
						break;
					}
					Y = i;
					X = j;

//					System.out.print(arr[j][i] + " ");

				}

//				System.out.println();

			}

			System.out.print(X + 1);

			if (Y + 1 < 10) {

				System.out.println("0" + (Y + 1));
			} else {
				System.out.println(Y + 1);

			}

		}
	}

}