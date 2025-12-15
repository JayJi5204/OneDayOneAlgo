package algo_251215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(nums[i]);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}