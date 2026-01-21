package algo_260121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++ ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Deque<int[]> queue = new ArrayDeque<int[]>();
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++ ) {
				int p = Integer.parseInt(st2.nextToken());
				queue.addLast(new int[]{i,p});
			}
			
			int count = 0;
			
			while(!queue.isEmpty()) {
			
				int[] current = queue.pollFirst();
				int curPriority = current[1];
				
				boolean hasHigherP = false;
				for( int[] check : queue) {
					if(check[1] > curPriority) {
						hasHigherP = true;
						break;
					}
				}
				
				if (hasHigherP) {
                    queue.addLast(current);
                } else {
                    count++;
                    if (current[0] == M) {       
                        System.out.println(count);
                        break;
                    }
                }
				
			}
		}
	}
}