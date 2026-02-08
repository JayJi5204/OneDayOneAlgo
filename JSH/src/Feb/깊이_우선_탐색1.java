package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 깊이_우선_탐색1 {


	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

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
			Collections.sort(list.get(i));
		}

		arr = new int[N + 1];
		count = 1;

		dfs(R);

		for (int i = 1; i < N + 1; i++) {
			sb.append(arr[i]).append("\n");
		}

		System.out.print(sb);

	}

	public static void dfs(int now) {
		visited[now] = true;
		arr[now] = count++;

		for (int i = 0; i < list.get(now).size(); i++) {
			int next = list.get(now).get(i);
			if (!visited[next]) {
				dfs(next);
			}
		}

	}
}