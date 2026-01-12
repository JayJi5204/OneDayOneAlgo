package algo_260112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(!map.containsKey(card)) {			
				map.put(card, 1);
			}else {
				map.put(card, map.get(card)+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int check = Integer.parseInt(st2.nextToken());
			Integer cnt = map.get(check);
			
			if(cnt == null) {
				sb.append("0"+" ");
			}else {
				sb.append(cnt+" ");
			}
		}
		System.out.println(sb);
	}
}