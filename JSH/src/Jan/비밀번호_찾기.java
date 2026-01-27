package Jan;

import java.util.HashMap;
import java.util.Scanner;

public class 비밀번호_찾기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		HashMap<String, Integer> set = new HashMap<>();

		String[] passwordArr = new String[N];

		for (int i = 0; i < N; i++) {

			String siteUrl = sc.next();

			set.put(siteUrl, i);

			String sitePassword = sc.next();

			passwordArr[i] = sitePassword;

		}

		for (int i = 0; i < M; i++) {

			String findUrl = sc.next();

			int value = set.get(findUrl);

			System.out.println(passwordArr[value]);

		}

	}

}
