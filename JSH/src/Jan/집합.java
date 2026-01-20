package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[] arr = new boolean[21];

	public static void main(String[] args) throws IOException {

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			if (input.equals("add")) {
				add(st);
			} else if (input.equals("check")) {
				check(st);
			} else if (input.equals("remove")) {
				remove(st);
			} else if (input.equals("toggle")) {
				toggle(st);
			} else if (input.equals("all")) {
				all();
			} else {
				empty();
			}
		}
		System.out.print(sb);
	}

	static void add(StringTokenizer st) {
		int input = Integer.parseInt(st.nextToken());
		arr[input] = true;
	}

	static void check(StringTokenizer st) {
		int input = Integer.parseInt(st.nextToken());
		if (arr[input]) {
			sb.append(1).append("\n");
		} else {
			sb.append(0).append("\n");
		}
	}

	static void remove(StringTokenizer st) {
		int input = Integer.parseInt(st.nextToken());
		arr[input] = false;
	}

	static void toggle(StringTokenizer st) {
		int input = Integer.parseInt(st.nextToken());
		if (arr[input]) {
			arr[input] = false;
		} else {
			arr[input] = true;
		}
	}

	static void all() {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = true;
		}
	}

	static void empty() {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = false;
		}
	}
}