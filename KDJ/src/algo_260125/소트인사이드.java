package algo_260125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소트인사이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		char[] nums = new char[input.length()];
		
		for(int i = 0; i< input.length(); i++) {
			nums[i] = input.charAt(i);
		}
		
		Arrays.sort(nums);
		
		char[]reverse = new char[input.length()];
		
		for (int i = 0; i < input.length(); i++) {
		    reverse[i] = nums[nums.length - 1 - i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< input.length();i++) {
			sb.append(reverse[i]);
		}
		System.out.println(sb);
	}
}