package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_3차원배열 {
	static StringBuilder sb;

	static int N, M, H;

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	static Queue<Node> queue;

	static class Node {
		int x, y, z;
		int distance;

		public Node(int x, int y, int z, int distance) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.distance = distance;
		}
	}

	static int[][][] arr;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];
		visited = new boolean[H][N][M];

		queue = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						queue.add(new Node(k, j, i, 0));
						visited[i][j][k] = true;
					}
					if (arr[i][j][k] == -1) {
						visited[i][j][k] = true;
					}
				}
			}
		}

		int result = bfs();
		int check = 0;

		for (int i = 0; i < H; i++) {
			if (check == 0) {
				for (int j = 0; j < N; j++) {
					if (check == 0) {
						for (int k = 0; k < M; k++) {
							if (!visited[i][j][k]) {
								check = 1;
								result = -1;
								break;
							}
						}
					}
				}
			}
		}

		sb.append(result);
		System.out.print(sb);

	}

	public static int bfs() {
		int count = 0;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];
				int nextZ = poll.z + dz[i];

				if (nextX < 0 || M <= nextX || nextY < 0 || N <= nextY || nextZ < 0 || H <= nextZ) {
					continue;
				}

				if (arr[nextZ][nextY][nextX] == -1) {
					continue;
				}

				if (!visited[nextZ][nextY][nextX]) {
					visited[nextZ][nextY][nextX] = true;
					queue.add(new Node(nextX, nextY, nextZ, poll.distance + 1));
					count = poll.distance + 1;
				}
			}
		}

		return count;

	}
}