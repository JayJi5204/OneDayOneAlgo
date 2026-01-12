package Jan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class 요세푸스문제0 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int K = sc.nextInt();

		Deque<Integer> queue = new ArrayDeque<>();

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		int count = 1;

		while (true) {

			if (queue.isEmpty()) {
				break;
			}

			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.getFirst());
				queue.removeFirst();
			}

			int target = queue.getFirst();
			list.add(target);
			queue.removeFirst();
		}
		System.out.print("<");
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				System.out.print(list.get(i));
			} else {

				System.out.print(list.get(i) + ", ");
			}

		}
		System.out.print(">");
	}
}
