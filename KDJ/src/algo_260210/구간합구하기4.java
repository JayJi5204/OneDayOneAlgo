package algo_260210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] prefix = new int[N+1];
		
		StringTokenizer number = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(number.nextToken());
            prefix[i] = prefix[i - 1] + x;
        }
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < M; tc++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(input.nextToken());
            int end = Integer.parseInt(input.nextToken());

            int ans = prefix[end] - prefix[start - 1];
            sb.append(ans).append('\n');
        }			
		System.out.println(sb);
	}
}