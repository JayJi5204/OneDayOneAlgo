package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는_친구가_필요해 {

	static StringBuilder sb;

	static int N, M, startX, startY;

	static char[][] arr;

	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };

	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];

		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}

		sb.append(bfs(startX, startY));
		System.out.print(sb);

	}

	public static String bfs(int startX, int startY) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startX, startY));
		visited[startX][startY] = true;

		int count = 0;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];

				if (nextX < 0 || N <= nextX || nextY < 0 || M <= nextY) {
					continue;
				}

				if (arr[nextX][nextY] == 'X') {
					continue;
				}

				if (!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					queue.add(new Node(nextX, nextY));
					if (arr[nextX][nextY] == 'P') {
						count++;
					}
				}

			}
		}

		if (count == 0) {
			return "TT";
		} else {

			return Integer.toString(count);
		}

	}
}