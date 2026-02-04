package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 창고_통행_가능_정보 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int storage = Integer.parseInt(st.nextToken());

		int road = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Edge>> list = new ArrayList<>();

		for (int i = 0; i <= storage; i++) {
			list.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			if (10 <= limit) {

				list.get(start).add(new Edge(end, limit));
				list.get(end).add(new Edge(start, limit));
			}
		}

		sb.append("[3번 창고 통행 가능 정보]").append("\n");

		for (int i = 0; i < list.get(3).size(); i++) {
			Edge edge = list.get(3).get(i);
			sb.append("목적지: ").append(edge.end).append(", 제한중량: ").append(edge.limit).append("\n");
		}

		System.out.print(sb);

	}
}

class Edge {
	int end;
	int limit;

	Edge(int end, int limit) {
		this.end = end;
		this.limit = limit;
	}
}