package Dec;

import java.util.Scanner;

public class 이항계수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int NValue = 1;
		int KValue = 1;
		int NminK = 1;

		for (int i = N; i > 0; i--) {
			NValue = NValue * i;
		}
//		System.out.println(NValue);

		for (int i = K; i > 0; i--) {
			KValue = KValue * i;
		}
//		System.out.println(KValue);

		for (int i = N - K; i > 0; i--) {
			NminK = NminK * i;
		}
//		System.out.println(NminK);

		System.out.println(NValue / (KValue * NminK));

	}
}