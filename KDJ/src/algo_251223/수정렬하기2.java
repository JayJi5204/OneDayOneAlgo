package algo_251223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		boolean[] nums = new boolean[2000001];
		
		for(int i = 0; i < N; i++) {
			nums[Integer.parseInt(br.readLine())+1000000] = true;
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]) {
				sb.append(i-1000000);
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
