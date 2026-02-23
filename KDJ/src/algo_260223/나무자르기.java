package algo_260223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] tree = new long[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		long max = 0;
		
		for(int i = 0; i < N; i++) {
			tree[i] = Long.parseLong(st2.nextToken());
			
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		long low = 0;
		long high = max;
		long ans = 0;
		
		while(low <= high) {
			long mid = (low + high)/2;
			
			long remain = 0;
			
			for(long len : tree) {
			   if (len > mid) remain += (len - mid);
			}
			
			if (remain >= M) {      
                ans = mid;
                low = mid + 1;
            } else {                
                high = mid - 1;
            }
		}
		System.out.println(ans);
	}
}