package Mar;

import java.io.*;
import java.util.*;

public class 보물 {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		ArrayList<Integer> B = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(A);
		Collections.sort(B, Collections.reverseOrder());

		int result = 0;

		for (int i = 0; i < N; i++) {
			result = result + A[i] * B.get(i);
		}
		sb.append(result);

		System.out.print(sb);

	}
}