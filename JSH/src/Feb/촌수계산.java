package Feb;

import java.io.*;
import java.util.*;

public class 촌수계산 {

	static StringBuilder sb;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;

	static int end;

	static class Node {
		int now;
		int distance;

		public Node(int now, int distance) {
			this.now = now;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}

		visited = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);

		}

		sb.append(bfs(start, end));
		System.out.print(sb);
	}

	public static int bfs(int now, int last) {
		Queue<Node> queue = new LinkedList<>();
		visited[now] = true;
		queue.add(new Node(now, 0));
		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			if (poll.now == last) {
				return poll.distance;
			}

			for (int i = 0; i < list.get(poll.now).size(); i++) {
				int next = list.get(poll.now).get(i);
				if (!visited[next]) {
					visited[next] = true;
					queue.add(new Node(next, poll.distance + 1));
				}
			}
		}
		return -1;
	}
}