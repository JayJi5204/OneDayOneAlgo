package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS {

	static ArrayList<ArrayList<Integer>> list;
	static boolean[] dfsVisited;
	static ArrayList<Integer> dfsCount;
	static boolean[] bfsVisited;
	static ArrayList<Integer> bfsCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		dfsVisited = new boolean[N + 1];
		dfsCount = new ArrayList<Integer>();

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

		for (int i = 0; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		dfs(V);

		for (int i = 0; i < dfsCount.size(); i++) {
			sb.append(dfsCount.get(i)).append(" ");
		}
		sb.append("\n");

		bfsVisited = new boolean[N + 1];
		bfsCount = new ArrayList<Integer>();

		bfs(V);
		for (int i = 0; i < bfsCount.size(); i++) {
			sb.append(bfsCount.get(i)).append(" ");
		}

		System.out.print(sb);

	}

	public static void dfs(int now) {
		dfsVisited[now] = true;
		dfsCount.add(now);

		for (int i = 0; i < list.get(now).size(); i++) {
			int next = list.get(now).get(i);
			if (!dfsVisited[next]) {
				dfs(next);
			}
		}

	}

	public static void bfs(int now) {
		Queue<Integer> queue = new LinkedList<>();

		bfsVisited[now] = true;
		bfsCount.add(now);
		queue.add(now);

		while (!queue.isEmpty()) {
			int poll = queue.poll();
			for (int i = 0; i < list.get(poll).size(); i++) {
				int next = list.get(poll).get(i);
				if (!bfsVisited[next]) {
					bfsVisited[next] = true;
					bfsCount.add(next);
					queue.add(next);
				}
			}
		}
	}
}