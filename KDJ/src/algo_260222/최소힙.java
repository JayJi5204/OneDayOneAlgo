package algo_260222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append('\n');
				}else {
					sb.append(pq.poll()).append('\n');					
				}				
			}else {
				pq.add(input);
			}
		}
		System.out.println(sb);
	}
}