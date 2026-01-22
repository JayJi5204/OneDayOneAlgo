package Jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class 듣보잡 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();

	static HashSet<String> set = new HashSet<>();

	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			set.add(input);
		}
		solution(M);
		result(list);

	}

	static void solution(int M) {
		for (int i = 0; i < M; i++) {

			String input = sc.next();

			if (set.contains(input)) {
				list.add(input);
			}
		}

	}

	static void result(ArrayList<String> list) {
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

		}
	}

}