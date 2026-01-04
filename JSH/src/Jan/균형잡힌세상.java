package Jan;

import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {

			Stack<Character> stack = new Stack<>();

			String result = "yes";

			String input = sc.nextLine();

			char[] charArr = input.toCharArray();

			int end = 0;

			for (int i = 0; i < charArr.length; i++) {

				if (charArr[i] == '.') {
					end = i;
					break;
				}

			}

			if (end == 0) {

				break;
			}

			for (int i = 0; i < end; i++) {

				if (charArr[i] == '(' || charArr[i] == '[') {
					stack.add(charArr[i]);
				}

				if (charArr[i] == ')') {

					if (stack.size() == 0) {
						result = "no";
						break;
					}

					char peek = stack.peek();

					if (peek == '(') {
						stack.pop();
					} else {
						result = "no";
						break;
					}

				}

				if (charArr[i] == ']') {

					if (stack.size() == 0) {
						result = "no";
						break;
					}

					char peek = stack.peek();

					if (peek == '[') {
						stack.pop();
					} else {
						result = "no";
						break;
					}

				}

			}

			if (stack.size() != 0) {
				result = "no";
			}
			System.out.println(result);

		}

	}
}
