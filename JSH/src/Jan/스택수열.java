package Jan;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
	static int VALUE = 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		Stack<String> outputStack = new Stack<>();

		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			solve(input, stack, outputStack);

		}

		checkOutputStack(outputStack);
		result(outputStack);

	}

	static void solve(int input, Stack<Integer> stack, Stack<String> outputStack) {
		while (true) {

			if (VALUE <= input) {
				stack.add(VALUE);
				VALUE++;
				outputStack.add("+");

			} else {
				int peek = stack.peek();
				if (peek == input) {
					stack.pop();
					outputStack.add("-");
					break;
				} else {
					outputStack.add("NO");
					break;
				}
			}
		}

	}

	static void checkOutputStack(Stack<String> stack) {
		for (int i = 0; i < stack.size(); i++) {

			if (stack.get(i).equals("NO")) {
				stack.clear();
				stack.add("NO");
				break;
			}

		}
	}

	static void result(Stack<String> stack) {
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i));

		}
	}
}