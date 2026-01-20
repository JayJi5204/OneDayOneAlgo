package algo_260120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {

	 public static void main(String[] args) throws IOException {
	       
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int M = Integer.parseInt(st.nextToken());
	        int N = Integer.parseInt(st.nextToken());

	        boolean[] Composite = new boolean[N + 1]; 
	       
	        if (N >= 0) {
	        	Composite[0] = true;
	        }
	        if (N >= 1) {
	        	Composite[1] = true;
	        }

	        for (int i = 2; i * i <= N; i++) {
	            if (!Composite[i]) {
	                for (int j = i * i; j <= N; j += i) {
	                    Composite[j] = true;
	                }
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        for (int i = Math.max(M, 2); i <= N; i++) {
	            if (!Composite[i]) sb.append(i).append('\n');
	        }
	        
	        System.out.print(sb);
	}
}