package Mar;

import java.io.*;
import java.util.*;

public class 랜선_자르기 {
	static StringBuilder sb;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long start = 1;
		long end = Integer.MAX_VALUE;
		long count;
		long result = 0;

		while (start <= end) {
			long mid = start + (end - start) / 2;
//			System.out.println("-----------------");
			count = 0;
			for (int i = 0; i < K; i++) {
				count = count + arr[i] / mid;
//				System.out.println(count);
			}

			if (N <= count) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;

			}

		}

		sb.append(result);

		System.out.print(sb);

	}
}