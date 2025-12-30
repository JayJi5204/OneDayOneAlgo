package Dec;

import java.util.Scanner;

public class 덩치 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Person[] person = new Person[N];

		for (int i = 0; i < N; i++) {
			person[i] = new Person();

		}

		for (int i = 0; i < N; i++) {
			person[i].weight = sc.nextInt();
			person[i].height = sc.nextInt();
			person[i].rank = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}

				if (person[i].weight < person[j].weight && person[i].height < person[j].height) {
					person[i].rank++;
				}
			}

		}

		for (int i = 0; i < N; i++) {
			System.out.println(person[i].rank);

		}

	}
}

class Person {
	int weight;
	int height;
	int rank;

}