package algo_251229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬하기 {

	  public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());

	        int[][] p = new int[N][2];

	        for (int i = 0; i < N; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            p[i][0] = Integer.parseInt(st.nextToken()); 
	            p[i][1] = Integer.parseInt(st.nextToken()); 
	        }

	        Arrays.sort(p, 좌표정렬하기::compare);
	           

	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < N; i++) {
	            sb.append(p[i][0]).append(' ').append(p[i][1]).append('\n');
	        }
	        System.out.print(sb);
	    }
	  
	  public static int compare(int[] a, int[] b) {
		  if (a[0] != b[0]) return Integer.compare(a[0], b[0]); 
          return Integer.compare(a[1], b[1]);
	  }
}

