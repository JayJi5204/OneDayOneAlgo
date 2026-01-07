package algo_260106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] sugar = new int[N+1];
		Arrays.fill(sugar, Integer.MAX_VALUE);
		sugar[0] = 0;
		
		for (int i = 1; i <= N; i++) {
            if (i - 3 >= 0 && sugar[i - 3] != Integer.MAX_VALUE) {
            	sugar[i] = Math.min(sugar[i], sugar[i - 3] + 1);
            }
            if (i - 5 >= 0 && sugar[i - 5] != Integer.MAX_VALUE) {
            	sugar[i] = Math.min(sugar[i], sugar[i - 5] + 1);
            }
        }
		
		if(sugar[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(sugar[N]);
		}
	}
}
