package algo_260108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {

	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        while (true) {
	            String line = br.readLine();
	            if (line.equals(".")) break;

	            Stack<Character> stack = new Stack<>();
	            boolean ok = true;

	            for (int i = 0; i < line.length(); i++) {
	                char c = line.charAt(i);

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
	                } else if (c == '.') {
	                    break; 
	                }
	            }

	            if (!stack.isEmpty()) ok = false;

	            if(ok) {
	            	System.out.println("yes");
	            }else {
	            	System.out.println("no");
	            }
	        }
	 }
}
