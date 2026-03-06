package Mar;

import java.io.*;
import java.util.*;

public class 나무_자르기 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long start = 1;
		long end = Integer.MAX_VALUE;
		long result = 0;

		while (start <= end) {

			long mid = start + (end - start) / 2;

//			System.out.println("-----------------");
//			System.out.println("mid: "+mid);
			long count = 0;

			for (int i = 0; i < N; i++) {

				long value = arr[i] - mid;
				if (value < 0) {
					continue;
				}
				count = count + value;
//				System.out.println("count: " + count);
			}

			if (M <= count) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}

		}

		sb.append(result);

		System.out.print(sb);

	}
}