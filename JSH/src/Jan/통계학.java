package Jan;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class 통계학 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		int[] checkPlusCount = new int[4001];
		int[] checkMinusCount = new int[4001];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();

			arr[i] = input;
			stack.add(input);

			if (input < 0) {
				input = input * -1;
				checkMinusCount[input]++;
			} else {
				checkPlusCount[input]++;
			}

		}

		firstResult(arr);
		secondResult(N, stack);
		thirdResult(checkPlusCount, checkMinusCount);
		fourthResult(stack);

	}

	static void firstResult(int[] arr) {
		double value = 0;
		int length = arr.length;

		for (int i = 0; i < length; i++) {
			value = value + arr[i];

		}

		int result = (int) Math.round(value / length);
		System.out.println(result);

	}

	static void secondResult(int N, Stack<Integer> stack) {

		Collections.sort(stack);

		System.out.println(stack.get(N / 2));

	}

	static void thirdResult(int[] checkPlusCount, int[] checkMinusCount) {

		int value = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < checkMinusCount.length; i++) {

			if (value == checkMinusCount[i]) {
				stack.add(i * -1);

			}
			if (value < checkMinusCount[i]) {
				value = checkMinusCount[i];
				stack.clear();
				stack.add(i * -1);
			}

		}

		for (int i = 0; i < checkPlusCount.length; i++) {

			if (value == checkPlusCount[i]) {
				stack.add(i);
			}
			if (value < checkPlusCount[i]) {
				value = checkPlusCount[i];
				stack.clear();
				stack.add(i);
			}

		}

		Collections.sort(stack);
		
		if(stack.size()==1) {
			System.out.println(stack.get(0));
		}else {
			
			System.out.println(stack.get(1));
		}


	}

	static void fourthResult(Stack<Integer> stack) {

		Collections.sort(stack);

		int value = stack.get(stack.size() - 1) - stack.get(0);

		System.out.println(value);

	}

}