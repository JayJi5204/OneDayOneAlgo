package Mar;

import java.io.*;
import java.util.*;

public class 수_찾기 {
	static StringBuilder sb;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int findValue = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;

			boolean find = false;

			while (start <= end) {
				int mid = (start + end) / 2;
				int midValue = arr[mid];
				if (findValue < midValue) {
					end = mid - 1;
				} else if (midValue < findValue) {
					start = mid + 1;
				} else {
					find = true;
					break;
				}
			}

			if (find) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.print(sb);

	}
}