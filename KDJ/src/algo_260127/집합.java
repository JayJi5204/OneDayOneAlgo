package algo_260127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("add")) {
				
				int num = Integer.parseInt(st.nextToken());
				
				set.add(num);
			}else if(command.equals("remove")) {
				
				int num = Integer.parseInt(st.nextToken());
				
				if(set.contains(num)) {
					set.remove(num);					
				}else {
					continue;
				}
			}else if(command.equals("check")) {
				
				int num = Integer.parseInt(st.nextToken());
				
				if(set.contains(num)) {
					sb.append("1").append("\n");					
				}else {
					sb.append("0").append("\n");
				}
				
			}else if(command.equals("toggle")) {
				
				int num = Integer.parseInt(st.nextToken());
				
				if(set.contains(num)) {
					set.remove(num);					
				}else {
					set.add(num);
				}
			}else if(command.equals("all")) {
				set.clear();
				
				for(int j = 1; j<= 20; j++) {
					set.add(j);
				}
			}else if(command.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}