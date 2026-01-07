package Jan;

import java.util.Scanner;
import java.util.Stack;

public class 제로 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			int input = sc.nextInt();

			if (input == 0) {
				stack.pop();
			} else {
				stack.add(input);
			}
		}

		int result = 0;

		for (int i = 0; i < stack.size(); i++) {
			result = result + stack.get(i);
		}
		System.out.println(result);

	}
}
