package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 토마토 {
	static StringBuilder sb;

	static int N, M;

	static int[][] arr;

	static boolean[][] visited;

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

	static ArrayList<Now> now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		visited = new boolean[M][N];
		now = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					now.add(new Now(j, i));
				}
				if (arr[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}

		sb.append(bfs());
		System.out.print(sb);

	}

	public static int bfs() {
		Queue<Node> queue = new LinkedList<>();

		int count = 0;

		for (int i = 0; i < now.size(); i++) {
			queue.add(new Node(now.get(i).startX, now.get(i).startY, 0));
			visited[now.get(i).startY][now.get(i).startX] = true;
//			System.out.print("startX: " + now.get(i).startX);
//			System.out.print(", startY: " + now.get(i).startY);
//			System.out.println();
		}

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];

				if (nextX < 0 || N <= nextX || nextY < 0 || M <= nextY) {
					continue;
				}

				if (arr[nextY][nextX] == -1) {
					continue;
				}

//				System.out.print("nextX: " + nextX);
//				System.out.print(", nextY: " + nextY);
//				System.out.println();

				if (!visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					queue.add(new Node(nextX, nextY, poll.distance + 1));
					count = Math.max(poll.distance + 1, count);
				}
			}
		}

		int check = 0;

		for (int i = 0; i < M; i++) {
			if (check == 1) {
				break;
			}

			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					check = 1;
					count = -1;
//					System.out.print(visited[i][j]);
//					System.out.print("i: " + i);
//					System.out.print(", j: " + j);
//					System.out.println();
					break;
				}
			}
		}
		return count;
	}
}

class Now {
	int startX;
	int startY;

	Now(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;
	}

}