package Jan;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();

		}

		Arrays.sort(arr);

		int plus = 0;

		int result = 0;

		for (int i = 0; i < N; i++) {

			plus = plus + arr[i];

			result = result + plus;

		}

		System.out.println(result);
	}

}
