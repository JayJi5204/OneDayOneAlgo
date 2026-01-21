package Jan;

import java.util.HashMap;
import java.util.Scanner;

public class 나는야_포켓몬_마스터_이다솜 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static HashMap<String, Integer> hash = new HashMap<>();
	static String[] arr = new String[N + 1];

	public static void main(String[] args) {

		for (int i = 1; i <= N; i++) {
			String name = sc.next();
			put(i, name);
		}

		for (int i = 0; i < M; i++) {
			String input = sc.next();
			check(input);

		}

	}

	static void put(int i, String name) {

		hash.put(name, i);
		arr[i] = name;
	}

	static void check(String input) {
		if (Character.isDigit(input.charAt(0))) {
			System.out.println(arr[Integer.parseInt(input)]);
		} else {
			System.out.println(hash.get(input));
		}

	}
}