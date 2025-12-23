package Nov;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UnionMaplestory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int[] unionLevel = { 60, 100, 140, 200, 250 };

		int N = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();

		int point = 0;

		int totalLevel = 0;

		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}

		Collections.sort(list, Collections.reverseOrder());
		int[] arr = new int[N];
		
		if (N <= 42) {
			for (int i = 0; i < N; i++) {
				arr[i] = list.get(i);

			}
		} else {
			for (int i = 0; i < 42; i++) {
				arr[i] = list.get(i);

			}
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}

		for (int i = 0; i < arr.length; i++) {
			totalLevel = totalLevel + arr[i];

			for (int j = 0; j < unionLevel.length; j++) {

				int value = arr[i] - unionLevel[j];

//				System.out.println("arr[" + i + "]: " + arr[i]);

				if (value < 0) {
					break;
				}

				point++;
			}

		}

		System.out.print(totalLevel+" ");
		System.out.println(point);

	}

}

