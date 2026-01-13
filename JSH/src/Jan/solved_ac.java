package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solved_ac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int upDown15 = (int) Math.round(n * 0.15);

        double sum = 0;
        for (int i = upDown15; i < n - upDown15; i++) {
            sum += arr[i];
        }

        int averageCount = n - (upDown15 * 2);
        System.out.println(Math.round(sum / averageCount));
    }
}