package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		String[] strArr = new String[st.countTokens()];

		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = st.nextToken();
		}

		int[] arr = new int[strArr.length];

		for (int i = 0; i < arr.length; i++) {

			if (strArr[i].contains("+")) {
				StringTokenizer split = new StringTokenizer(strArr[i], "+");
				int count = 0;
				int tokens = split.countTokens();
				for (int j = 0; j < tokens; j++) {
					count += Integer.parseInt(split.nextToken());
				}
				arr[i] = count;

			} else {
				arr[i] = Integer.parseInt(strArr[i]);
			}

		}

		int result = arr[0];

		for (int i = 1; i < arr.length; i++) {
			result -= arr[i];
		}

		sb.append(result);

		System.out.print(sb);

	}
}