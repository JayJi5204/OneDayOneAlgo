package algo_260306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {

	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        int N = Integer.parseInt(br.readLine());
	        int S = Integer.parseInt(br.readLine());
	        
	        String input = br.readLine();

	        int ans = 0;
	        int cnt = 0;

	        for (int i = 1; i < S - 1; i++) {
	            if (input.charAt(i - 1) == 'I' && input.charAt(i) == 'O' && input.charAt(i + 1) == 'I') {
	            	cnt++;

	                if (cnt >= N) {
	                    ans++;
	                }

	                i++; 
	            } else {
	            	cnt = 0;
	            }
	        }
	        System.out.println(ans);
	    }
}