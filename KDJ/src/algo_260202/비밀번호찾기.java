package algo_260202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer nums = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(nums.nextToken());
		int M = Integer.parseInt(nums.nextToken());
		
		Map<String,String> map = new HashMap<String, String>();
		
		for(int i = 0; i < N; i++) {
			
			StringTokenizer input = new StringTokenizer(br.readLine());
			map.put(input.nextToken(), input.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(map.get(site)).append('\n');
		}
		System.out.println(sb);
	}
}