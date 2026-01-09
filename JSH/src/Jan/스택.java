package Jan;

import java.util.Scanner;
import java.util.Stack;

public class 스택 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String input = sc.next();

			if (input.equals("push")) {
				int nextInput = sc.nextInt();
				stack.push(nextInput);
				
			} else if (input.equals("top")) {
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				
			} else if (input.equals("size")) {
				System.out.println(stack.size());
				
			} else if (input.equals("empty")) {
				if (stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				
			} else if (input.equals("pop")) {
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
					stack.pop();
				}
			}

		}

	}
}
