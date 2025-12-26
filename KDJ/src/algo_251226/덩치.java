package algo_251226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] w = new int[N];
		int[] h = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w[i] = Integer.parseInt(st.nextToken());
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int place = 1;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				
				if (w[j] > w[i] && h[j] > h[i]) {
                    place++;
                }
			}
			System.out.print(place + " ");
		}
	}
}
