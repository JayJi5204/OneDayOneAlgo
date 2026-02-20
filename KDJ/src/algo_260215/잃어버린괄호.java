package algo_260215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] minusParts = input.split("-");

        int result = sumPlus(minusParts[0]);
        for (int i = 1; i < minusParts.length; i++) {
            result -= sumPlus(minusParts[i]);
        }

        System.out.println(result);
    }

    private static int sumPlus(String part) {
        String[] plusParts = part.split("\\+"); 
        int sum = 0;
        for (String p : plusParts) {
            sum += Integer.parseInt(p);
        }
        return sum;
    }
}