package algo_260122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int cur = 1;
		boolean possible = true;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            while (cur <= x) {
                stack.push(cur);
                sb.append("+\n");
                cur++;
            }

            if (!stack.isEmpty() && stack.peek() == x) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }
	}
}