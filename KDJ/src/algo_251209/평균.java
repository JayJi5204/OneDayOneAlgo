package algo_251209;

import java.util.Scanner;

public class 평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] scores = new double[N];
		
		double max = 0;
		
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextDouble();
			if(max < scores[i]) {
				max = scores[i];
			}
		}
		
		double avg = 0;
		double sum = 0;
		
		for(int i = 0; i < N; i++) {
			scores[i] = (scores[i]/max)*100; 
			sum += scores[i];
		}
		
		avg = sum/N;
		

		System.out.println(avg);
	}
}
