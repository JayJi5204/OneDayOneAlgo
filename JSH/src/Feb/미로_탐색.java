package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미로_탐색 {

	static StringBuilder sb;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[][] arr;
	static boolean[][] visited;

	static int N, M;

	static class Node {
		int x;
		int y;
		int distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {

			String str = br.readLine();
			for (int j = 0; j < M; j++) {

				arr[i][j] = str.charAt(j) - '0';
			}
		}

		sb.append(bfs(0, 0, 1));
		System.out.print(sb);

	}

	public static int bfs(int x, int y, int distance) {
		Queue<Node> queue = new LinkedList<>();

		visited[x][y] = true;
		queue.add(new Node(x, y, distance));

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			if (poll.x == N - 1 && poll.y == M - 1) {
				return poll.distance;
			}

			for (int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (!visited[nx][ny] && arr[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny, poll.distance + 1));

					}
				}
			}

		}
		return 0;

	}
}