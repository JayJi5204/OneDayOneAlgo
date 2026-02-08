package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은_넘겠지 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			double sum = 0;

			double[] arr = new double[N];

			for (int j = 0; j < N; j++) {
				arr[j] = Double.parseDouble(st.nextToken());
				sum = sum + arr[j];

			}

			double average = sum / N;

			double count = 0;
			for (int j = 0; j < N; j++) {
				if (average < arr[j]) {
					count++;
				}
			}

			double result = (count / N) * 100;

			sb.append(String.format("%.3f%%", result)).append("\n");

		}
		System.out.print(sb);

	}
}