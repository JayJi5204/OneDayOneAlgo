package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());

			int end = Integer.parseInt(st.nextToken());

			list.get(start).add(end);
			list.get(end).add(start);

		}

		dfs(1);

		System.out.print(count);

	}

	public static void dfs(int now) {

		visited[now] = true;

		for (int i = 0; i < list.get(now).size(); i++) {
			int next = list.get(now).get(i);
			if (!visited[next]) {
				count++;
				dfs(next);
			}
		}

	}
}
