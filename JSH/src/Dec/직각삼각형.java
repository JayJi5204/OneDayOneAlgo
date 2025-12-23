package Dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 직각삼각형 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> list = new ArrayList<Integer>(3);

		while (true) {

			for (int i = 0; i < 3; i++) {
				list.add(sc.nextInt());

			}

			if (list.get(0) == 0 && list.get(1) == 0 && list.get(2) == 0) {
				break;
			}

			Collections.sort(list, Collections.reverseOrder());

			double a = list.get(0);
			a = Math.pow(a, 2);

			double b = list.get(1);
			b = Math.pow(b, 2);

			double c = list.get(2);
			c = Math.pow(c, 2);

			if (a == b + c) {
				System.out.println("right");
			} else {
				System.out.println("wrong");

			}

//			System.out.println(list.toString());

			list.removeAll(list);
		}

	}
}
