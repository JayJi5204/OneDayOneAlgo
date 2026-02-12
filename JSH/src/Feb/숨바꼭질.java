package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

	static StringBuilder sb;
	static int N, K;
	static boolean[] visited;

	static class Node {
		int start;
		int distance;

		public Node(int start, int distance) {
			this.start = start;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		sb.append(bfs(N, 0));
		System.out.print(sb);

	}

	public static int bfs(int now, int distance) {
		Queue<Node> queue = new LinkedList<>();

		visited[now] = true;

		queue.add(new Node(now, distance));

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			if (poll.start == K) {
				return poll.distance;
			}
			int[] arr = { poll.start - 1, poll.start + 1, poll.start * 2 };
			for (int i = 0; i < 3; i++) {
				int check = arr[i];
				if (0 <= check && check <= 100000) {
					if (!visited[check]) {
						visited[check] = true;
						queue.add(new Node(check, poll.distance + 1));
					}
				}
			}
		}
		return 0;
	}
}