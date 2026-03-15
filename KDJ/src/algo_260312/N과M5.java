package algo_260312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5 {

	 static int N, M;
	 static int[] arr, num;
	 static boolean[] visited;
	 static StringBuilder sb = new StringBuilder();

	 public static void main(String[] args) throws IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());

	     N = Integer.parseInt(st.nextToken());
	     M = Integer.parseInt(st.nextToken());

	     num = new int[N];
	     arr = new int[M];
	     visited = new boolean[N];

	     StringTokenizer nums = new StringTokenizer(br.readLine());
	     for (int i = 0; i < N; i++) {
	         num[i] = Integer.parseInt(nums.nextToken());
	     }

	     Arrays.sort(num);

	     dfs(0);

	     System.out.print(sb);
	 }

	 public static void dfs(int depth) {
	     if (depth == M) {
	         for (int i = 0; i < M; i++) {
	             sb.append(arr[i]).append(" ");
	         }
	         sb.append("\n");
	         return;
	     }

	     for (int i = 0; i < N; i++) {
	         if (visited[i]) continue;

	         visited[i] = true;
	         arr[depth] = num[i];
	         dfs(depth + 1);
	         visited[i] = false;
	     }
	 }
}