package Dec;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int count = N;

		while (true) {
			if (count == 1)
				break;

			queue.remove();
			Integer nextValue = queue.remove();
			queue.add(nextValue);
			count--;
		}
		System.out.println(queue.peek());

	}
}