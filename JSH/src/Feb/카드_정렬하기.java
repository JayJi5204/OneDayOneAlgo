package Feb;

import java.io.*;
import java.util.*;

public class 카드_정렬하기 {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(br.readLine());
			pq.add(card);
		}

		while (true) {
			if (pq.size() == 1) {
				break;
			}

			int card1 = pq.poll();
			int card2 = pq.poll();

			int count = card1 + card2;
			result = result + count;
			pq.add(count);

		}

		sb.append(result);
		System.out.print(sb);

	}
}