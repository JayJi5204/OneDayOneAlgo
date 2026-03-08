package algo_260308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;

public class 절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                }
                return Math.abs(a) - Math.abs(b);
            }
        });
		
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