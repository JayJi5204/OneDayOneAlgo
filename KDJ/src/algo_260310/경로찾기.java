package algo_260310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {

	static int N;
    static int[][] graph;
    static int[][] answer;
    static boolean[] visited;

    public static void dfs(int start) {
        for (int next = 0; next < N; next++) {
            if (graph[start][next] == 1 && !visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i);

            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    answer[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}