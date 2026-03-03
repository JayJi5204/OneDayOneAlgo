package algo_260303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과일탕후루 {

	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());

	        int[] arr = new int[N];
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

	        int[] cnt = new int[9 + 1]; 
	        int distinct = 0;

	        int left = 0;
	        int ans = 0;

	        for (int right = 0; right < N; right++) {
	            if (cnt[arr[right]] == 0) {
	            	distinct++;
	            }
	            
	            cnt[arr[right]]++;

	            while (distinct > 2) {
	                cnt[arr[left]]--;
	                
	                if (cnt[arr[left]] == 0) {
	                	distinct--;
	                }
	                left++;
	            }
	            ans = Math.max(ans, right - left + 1);
	        }
	        System.out.println(ans);
	    }
}