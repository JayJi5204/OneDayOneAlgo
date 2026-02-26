package algo_260226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			sorted[i] = nums[i];
		}
		
		Arrays.sort(sorted);
		
		HashMap<Integer, Integer> rank = new HashMap<>(N * 2);
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (!rank.containsKey(sorted[i])) {
                rank.put(sorted[i], idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            sb.append(rank.get(nums[i]));
            if (i < N - 1) sb.append(' ');
        }
        System.out.println(sb.toString());
	}
}