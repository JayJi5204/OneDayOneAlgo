package algo_260109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			String line = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean ok = true;

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        ok = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        ok = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) ok = false;

            if(ok) {
            	System.out.println("YES");
            }else {
            	System.out.println("NO");
            }
        }
	}
}
