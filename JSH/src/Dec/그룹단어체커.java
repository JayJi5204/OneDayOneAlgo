package Dec;

import java.util.Scanner;

public class 그룹단어체커 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = N;

		for (int i = 0; i < N; i++) {

			String word = sc.next();

			char[] arr = word.toCharArray();

			boolean check = false;

			for (int j = 0; j < arr.length; j++) {
				char now = arr[j];
//				System.out.println("-------------------");
//				System.out.println("arr[" + j + "]: " + now);
//				System.out.println("j: " + j);

				boolean warning = true;

				for (int k = j+1; k < arr.length; k++) {
//					System.out.println("arr[" + k + "]: " + arr[k]);
					if (arr[k] != now) {
						warning = false;
					}

					if (warning == false && arr[k] == now) {
						check = true;
						count--;
//						System.out.println("count: " + count);
						break;
					}
				}
				if (check) {
					break;
				}
			}
//			System.out.println("lastCount:" + count);
		}
		System.out.println(count);
	}
}
