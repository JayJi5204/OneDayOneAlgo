package algo_260119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] chess = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			chess[i] = input.toCharArray();
		}

		int ans = 65;

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {

				int diff = 0;

				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						
						char check = ((x+y)%2==0) ? 'W' : 'B';

						if (chess[x][y] != check) {
							diff++;
						}
					}
				}
				int min = Math.min(diff, 64 - diff);

				ans = Math.min(min, ans);
			}
		}
		System.out.println(ans);
	}
}