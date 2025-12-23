package Dec;

import java.util.Scanner;

public class 웰컴키트 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		double[] Tshirts = new double[6];
		double[] Tshirt = new double[6];
		boolean[] check = new boolean[6];

		int count = 0;

		int N = sc.nextInt();

		for (int i = 0; i < Tshirts.length; i++) {
			Tshirts[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		int P = sc.nextInt();

		if (T == 1) {
			for (int i = 0; i < Tshirts.length; i++) {

				count = count + (int) Tshirts[i];
			}
		} else {

			for (int i = 0; i < Tshirts.length; i++) {
				count = count + (int) Tshirts[i] / T;
				Tshirt[i] = Tshirts[i] % T;

				if (Tshirt[i] != 0) {
					count++;
				}
			}

		}

		int pens = N / P;
		int pen = N % P;
		System.out.println(count);

		System.out.print(pens + " ");

		System.out.println(pen);
	}

}