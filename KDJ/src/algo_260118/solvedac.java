package algo_260118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solvedac {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N]; 
		
		for(int i = 0; i< N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		int cut = (int) Math.round(N * 0.15);
		
		double sum = 0;
		
		for(int i = cut; i< N-cut; i++) {
			sum += nums[i];
		}
		
		int ans = (int) Math.round((double)sum/(N-2*cut));
		
		System.out.println(ans);
	}
}