package algo_251125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UnionMaplestory {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int range[] = {0, 60, 100, 140, 200, 250, 301};
		
		List<Integer> union = new ArrayList<>();
		
		for(int i = 0; i < number; i++) {
			union.add(sc.nextInt());
		}
		Collections.sort(union);
		Collections.reverse(union);
		
		int sum = 0;
		int gain = 0;
		
		if(number < 43) {
			for(int i = 0; i<number; i++) {
				for(int j = 0; j < 6; j++) {
					if(union.get(i) >= range[j] && union.get(i) < range[j+1]) {
						gain += j;
					}
				}
				sum+= union.get(i);
			}
		}else {
			for(int i = 0; i < 42; i++) {
				for(int j = 0; j < 6; j++) {
					if(union.get(i) >= range[j] && union.get(i) < range[j+1]) {
						gain += j;
					}
				}
				sum+= union.get(i);
			}
		}
		
		System.out.println(sum+" "+gain);
	}
}
