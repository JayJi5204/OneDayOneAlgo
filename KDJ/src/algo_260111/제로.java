package algo_260111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < K; i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			if(N != 0) {
				stack.add(N);
			}else if(N == 0) {
				stack.pop();
			}
		}
		
		int ans = 0;
		
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		System.out.println(ans);
	}
}
