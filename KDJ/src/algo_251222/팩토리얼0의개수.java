package algo_251222;

import java.util.Scanner;

public class 팩토리얼0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
        int count = 0;
        
        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }
        System.out.println(count);
	}
}
