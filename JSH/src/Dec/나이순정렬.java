package Dec;

import java.util.ArrayList;
import java.util.Scanner;

public class 나이순정렬 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		ArrayList<String>[] member = new ArrayList[201];

		for (int i = 0; i < member.length; i++) {

			member[i] = new ArrayList<>();

		}

		for (int i = 0; i < N; i++) {
			int arrNumber = sc.nextInt();
			member[arrNumber].add(sc.next());
		}

		for (int i = 0; i < member.length; i++) {
			for (int j = 0; j < member[i].size(); j++) {
				System.out.print(i + " ");
				System.out.println(member[i].get(j));

			}
		}
	}
}