package algo_260123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 통계학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] count = new int[8001];
		int[] nums = new int[N];
		
		double sum = 0;
		
		for(int i = 0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			count[x+4000] += 1;
			nums[i] = x;

			sum += (double)x;
	
		}
		
		Arrays.sort(nums);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(Math.round(sum/N)).append('\n');
		
		sb.append(nums[N/2]).append('\n');
		
		
        int maxcount = 0;
        for (int i = 0; i <= 8000; i++) {
            if (count[i] > maxcount) maxcount = count[i];
        }

        int mode = 0;
        
        boolean firstFound = false;
        
        for (int i = 0; i <= 8000; i++) {
            if (count[i] == maxcount) {
                if (!firstFound) {
                    mode = i - 4000;     
                    firstFound = true;
                } else {
                    mode = i - 4000;     
                    break;
                }
            }
        }
        sb.append(mode).append('\n');
		
		sb.append(nums[N-1] - nums[0]).append('\n');
		
		System.out.println(sb);
	}
}