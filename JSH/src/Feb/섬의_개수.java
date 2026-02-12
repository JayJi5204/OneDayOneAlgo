package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의_개수 {
	static StringBuilder sb;

	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dy = { 1, 1, 1, 0, 0, -1, -1, -1 };

	static int[][] arr;
	static boolean[][] visited;

	static int w, h;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			arr = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {

				st = new StringTokenizer(br.readLine());

				int length = st.countTokens();
				for (int j = 0; j < length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}

			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}

	public static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];

				if (0 <= nx && nx < h && 0 <= ny && ny < w) {
					if (!visited[nx][ny] && arr[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny));
					}
				}
			}
		}
	}
}
