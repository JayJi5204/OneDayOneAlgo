package algo_251201;

import java.util.Arrays;
import java.util.Scanner;

public class 장신구명장임스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int N = sc.nextInt();
		
		int[] items = new int[N];
		
		for(int i = 0; i < N; i++) {
			items[i] = sc.nextInt();
		}
		
		Arrays.sort(items);
		
		int cnt = 0;
		
		while(p < 200) {
			for(int i = 0; i < N; i++) {
				p += items[i];
				cnt++;
				if(p >= 200) break;
			}
			break;
		}
		
		System.out.println(cnt);
	}
}
