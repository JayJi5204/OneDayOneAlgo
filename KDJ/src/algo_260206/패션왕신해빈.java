package algo_260206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String type = st.nextToken();
				
				if(!map.containsKey(type)) {
					map.put(type, 1);
				}else {
					map.put(type, map.get(type)+1);
				}		
			}
			
			int ans = 1;
			
			for(int cnt : map.values()) {
				ans *= (cnt + 1);
			}	
			sb.append(ans-1).append('\n');
		}
		System.out.println(sb);
	}
}