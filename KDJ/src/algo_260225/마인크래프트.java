package algo_260225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer nums = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(nums.nextToken());
		int M = Integer.parseInt(nums.nextToken());
		int B = Integer.parseInt(nums.nextToken());
		
		int[][] land = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long bestTime = Long.MAX_VALUE;
		int bestH = -1;

		for (int h = 0; h <= 256; h++) {
		    int inven = B;
		    long time = 0;

		    for (int i = 0; i < N; i++) {
		        for (int j = 0; j < M; j++) {
		            int cur = land[i][j];

		            if (cur > h) {
		                int diff = cur - h;
		                inven += diff;
		                time += (long) diff * 2;
		            } else if (cur < h) {
		                int diff = h - cur;
		                inven -= diff;
		                time += diff;
		            }
		        }
		    }

		    if (inven < 0) continue; 

		    if (time < bestTime || (time == bestTime && h > bestH)) {
		        bestTime = time;
		        bestH = h;
		    }
		}
		System.out.println(bestTime + " " + bestH);
	}
}