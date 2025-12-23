package Dec;

import java.util.Scanner;

public class 부녀회장이될테야 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 0; i < testCase; i++) {

			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] arr = new int[k + 1][n];

			for (int j = 0; j < n; j++) {
				arr[0][j] = j + 1;
			}

			for (int j = 1; j < k + 1; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if (j2 == 0) {
						arr[j][j2] = 1;
					} else {
						for (int l = 0; l <= j2; l++) {
							arr[j][j2] = arr[j][j2] + arr[j - 1][l];
						}
					}
				}
			}

			System.out.println(arr[k][n - 1]);
		}

	}
}
