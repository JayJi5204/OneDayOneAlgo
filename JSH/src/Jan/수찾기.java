package Jan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 수찾기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {

			int value = sc.nextInt();

			if (set.contains(value)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		}

	}
}
