package Mar;

import java.io.*;
import java.util.*;

public class 회의실_배정 {

	static StringBuilder sb;

	static class Room {
		int start, end;

		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static boolean[] visited;

	static ArrayList<Room> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		list = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			list.add(new Room(startTime, endTime));
		}

		Collections.sort(list, (a, b) -> {
			if (a.end == b.end) {
				return a.start - b.start;
			}
			return a.end - b.end;
		});

		int result = 0;
		int lastEnd = 0;

		for (int i = 0; i < N; i++) {
			Room room = list.get(i);

			if (lastEnd <= room.start) {
				lastEnd = room.end;
				result++;
			}
		}

		sb.append(result);
		System.out.print(sb);
	}

}
