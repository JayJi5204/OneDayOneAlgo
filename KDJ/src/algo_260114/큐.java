package algo_260114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("push")) {
				
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				
			}else if(command.equals("pop")) {
				
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.poll());
				}
				
			}else if(command.equals("size")) {
				
				System.out.println(queue.size());
				
			}else if(command.equals("empty")) {
				
				if(queue.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				
			}else if(command.equals("front")) {

				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.getFirst());
				}
			}else if(command.equals("back")) {

				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.getLast());
				}
			}
		}
	}
}