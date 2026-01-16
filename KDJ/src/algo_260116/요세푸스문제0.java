package algo_260116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class 요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
        sb.append("<");
		
		while(!deque.isEmpty()) {
			 for (int i = 0; i < K - 1; i++) {
	                deque.offer(deque.poll());
			 }
			 
			 sb.append(deque.poll());
		     if (!deque.isEmpty()) sb.append(", ");
		}    
        sb.append(">");
        System.out.print(sb.toString());
		
	}
}
