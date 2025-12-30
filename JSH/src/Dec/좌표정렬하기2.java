package Dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 좌표정렬하기2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		ArrayList<Integer>[] upList = new ArrayList[100001];
		ArrayList<Integer>[] downList = new ArrayList[100001];

		for (int i = 0; i < upList.length; i++) {
			downList[i] = new ArrayList<>();
			upList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {

			int arrValue = sc.nextInt();

			int arrNumber = sc.nextInt();

			if (arrNumber < 0) {
				int downListArrNumber = arrNumber * -1;
				downList[downListArrNumber].add(arrValue);
			} else {
				upList[arrNumber].add(arrValue);
			}
		}

		for (int i = 0; i < upList.length; i++) {
			Collections.sort(downList[i]);
			Collections.sort(upList[i]);
		}

		for (int i = downList.length - 1; i > 0; i--) {
			for (int j = 0; j < downList[i].size(); j++) {
				System.out.print(downList[i].get(j) + " ");
				System.out.println(i * -1);
			}

		}

		for (int i = 0; i < upList.length; i++) {
			for (int j = 0; j < upList[i].size(); j++) {
				System.out.print(upList[i].get(j) + " ");
				System.out.println(i);

			}
		}

	}
}