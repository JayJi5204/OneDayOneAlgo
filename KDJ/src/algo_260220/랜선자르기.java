package algo_260220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] line = new long[K];
		
		long maxlen = 0;
		
		for(int i = 0; i < K; i++) {
			line[i] = Long.parseLong(br.readLine());
			
			if(maxlen < line[i]) {
				maxlen = line[i];
			}
		}
		
		long low = 1;
		long high = maxlen;
		long ans = 0;
		
		while(low <= high) {
			long mid = (low + high)/2;
			
			long cnt = 0;
			
			for(long len:line) {
				cnt += (len / mid);
			}
			
			if (cnt >= N) {      
                ans = mid;
                low = mid + 1;
            } else {                
                high = mid - 1;
            }
		}
		System.out.println(ans);
	}
}