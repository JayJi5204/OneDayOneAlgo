package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙 {

	static StringBuilder sb;
	static ArrayList<ArrayList<Integer>> list;

	static boolean[] visited;

	static Queue<Node> queue;

	static class Node {
		int x, distance;

		public Node(int x, int distance) {
			this.x = x;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);

		}

		int min = 100000000;
		int result = 50002;

		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				visited = new boolean[N + 1];
				if (i == j) {
					continue;
				}
				count = count + bfs(i, j);
			}

			if (count < min) {
				min = count;
				result = i;
			}

		}

		sb.append(result);
		System.out.print(sb);

	}

	public static int bfs(int start, int end) {

		queue = new LinkedList<>();

		queue.add(new Node(start, 0));
		visited[start] = true;
//		System.out.println("-------------------");
//		System.out.println("end: " + end);

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
//			System.out.println("x: " + poll.x);

			if (poll.x == end) {
//				System.out.println("distance: " + poll.distance);
				return poll.distance;
			}
			for (int i = 0; i < list.get(poll.x).size(); i++) {
				int next = list.get(poll.x).get(i);

				if (!visited[next]) {
//					System.out.println("next: " + next);
					visited[next] = true;
					queue.add(new Node(next, poll.distance + 1));

				}
			}
		}

		return 0;
	}
}