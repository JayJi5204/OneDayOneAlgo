package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리 {
	static StringBuilder sb;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {

		int x, y, distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

	}

	static int[][] arr;

	static int N, M, startX, startY;

	static boolean[][] visited;

	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];
		result = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = -1;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					startX = i;
					startY = j;
					result[i][j] = 0;
				}
				if (arr[i][j] == 0) {
					result[i][j] = 0;
				}
			}
		}

		bfs(startX, startY);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	public static void bfs(int startX, int startY) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];

				if (nextX < 0 || N <= nextX || nextY < 0 || M <= nextY) {
					continue;
				}
				if (arr[nextX][nextY] == 0) {
					continue;
				}

				if (!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					queue.add(new Node(nextX, nextY, poll.distance + 1));
					result[nextX][nextY] = poll.distance + 1;
				}
			}
		}
	}
}
