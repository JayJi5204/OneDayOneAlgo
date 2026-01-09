package Jan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Deque<Integer> queue = new ArrayDeque<>();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			if (input.equals("push")) {
				int nextInput = sc.nextInt();
				queue.offer(nextInput);
			} else if (input.equals("front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.getFirst());
				}

			} else if (input.equals("back")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.getLast());
				}
			} else if (input.equals("size")) {
				System.out.println(queue.size());
			} else if (input.equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (input.equals("pop")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
					queue.removeFirst();
				}
			}

		}

	}
}
