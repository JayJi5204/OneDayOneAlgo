package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단지번호붙이기 {

	static ArrayList<Integer> list;
	static int[][] arr;
	static boolean[][] visited;

	static int N;
	static StringBuilder sb;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
					count++;
				}
			}
		}

		sb.append(count).append("\n");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.print(sb);

	}

	public static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		int count = 1;

		visited[x][y] = true;
		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (arr[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny));
						count++;
					}
				}

			}
		}

		list.add(count);
	}

}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}