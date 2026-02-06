package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {

	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(u).add(v);
			list.get(v).add(u);

		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}

		}

		sb.append(count);
		System.out.print(sb);

	}

	public static void dfs(int now) {
		visited[now] = true;

		for (int i = 0; i < list.get(now).size(); i++) {
			int next = list.get(now).get(i);
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}