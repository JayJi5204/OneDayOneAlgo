package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 적록색약 {
	static StringBuilder sb;

	static int N, count;

	static char[][] arr;

	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x, y;
		char color;

		public Node(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];

		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]) {
					bfsNot(j, i);
					count++;
				}
			}
		}
		sb.append(count).append(" ");

		count = 0;
		
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]) {
					bfs(j, i);
					count++;
				}
			}
		}
		sb.append(count);
		System.out.print(sb);
	}

	public static void bfsNot(int x, int y) {

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(x, y, arr[y][x]));

		visited[y][x] = true;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];

				if (nextX < 0 || N <= nextX || nextY < 0 || N <= nextY) {
					continue;
				}
				if (visited[nextY][nextX]) {
					continue;
				}

				if (!visited[nextY][nextX] && arr[nextY][nextX] == poll.color) {
					visited[nextY][nextX] = true;
					queue.add(new Node(nextX, nextY, poll.color));

				}
			}
		}

	}

	public static void bfs(int x, int y) {

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(x, y, arr[y][x]));

		visited[y][x] = true;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];

				if (nextX < 0 || N <= nextX || nextY < 0 || N <= nextY) {
					continue;
				}
				if (visited[nextY][nextX]) {
					continue;
				}

				if (!visited[nextY][nextX] && arr[nextY][nextX] == poll.color) {
					visited[nextY][nextX] = true;
					queue.add(new Node(nextX, nextY, poll.color));

				}
			}
		}

	}

}
