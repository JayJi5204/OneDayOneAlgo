package Jan;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			String result = "YES";

			Stack<Character> stack = new Stack<>();

			String input = sc.next();

			char[] charArr = input.toCharArray();

			for (int j = 0; j < charArr.length; j++) {

				if (charArr[j] == '(') {
					stack.add(charArr[j]);
				} else {
					if (j == 0) {
						result = "NO";
						break;
					} else if (stack.empty()) {
						result = "NO";
						break;
					}

					else {
						stack.pop();
					}

				}

			}
			if (!stack.empty()) {
				result = "NO";
			}
			System.out.println(result);

		}

	}
}
