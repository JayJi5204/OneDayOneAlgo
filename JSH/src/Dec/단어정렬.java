package Dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class 단어정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		HashSet<String> newSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			newSet.add(sc.next());

		}

		ArrayList<String> list = new ArrayList<>(newSet);

		ArrayList<String>[] listArr = new ArrayList[51];

		for (int i = 0; i < listArr.length; i++) {
			listArr[i] = new ArrayList<>();
		}

		for (int i = 0; i < list.size(); i++) {
			int wordLength = list.get(i).length();

			listArr[wordLength].add(list.get(i));
		}

		for (int i = 1; i < listArr.length; i++) {
			Collections.sort(listArr[i]);

		}

		for (int i = 1; i < listArr.length; i++) {
			for (int j = 0; j < listArr[i].size(); j++) {
				System.out.println(listArr[i].get(j));

			}

		}

	}
}