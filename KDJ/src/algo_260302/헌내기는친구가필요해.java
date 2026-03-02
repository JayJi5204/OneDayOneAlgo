package algo_260302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer nums = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(nums.nextToken());
		M = Integer.parseInt(nums.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];

		
		int startX = -1;
		int startY = -1;
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0 ; j < M; j++) {
				map[i][j] = line.charAt(j);
				
				if(map[i][j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}
		
		int count = bfs(startX, startY);

        if (count == 0) System.out.println("TT");
        else System.out.println(count);
	}
	
	static int bfs(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        int found = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (map[x][y] == 'P') found++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue; 

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return found;
    }
}