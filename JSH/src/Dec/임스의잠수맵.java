package Dec;

import java.util.Scanner;

public class 임스의잠수맵 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int S = sc.nextInt();
		int V = sc.nextInt();

		int L = sc.nextInt();

		int time = 30;

		int needExp = (250 - L) * 100;

		int needTime = 0;

		boolean check = false;
		
//		System.out.println(needExp);
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < time; j++) {
				needExp = needExp - C;
				needTime++;
				if (needExp <= 0) {
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
		}
//		System.out.println(needExp);

		for (int i = 0; i < S; i++) {
			if (check) {
				break;
			}

			for (int j = 0; j < time; j++) {
				needExp = needExp - B;
				needTime++;
				if (needExp <= 0) {
					check = true;
					break;
				}
			}
		}

		int value = needExp;
//		System.out.println(value);

		for (int i = 0; i < value; i++) {
			if (needExp <= 0) {
				check = true;
				break;
			}
			needExp = needExp - A;
			needTime++;
		}

//		System.out.println(needExp);
		System.out.println(needTime);

	}

}
