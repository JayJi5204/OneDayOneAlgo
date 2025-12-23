package algo_251218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int next = 0;
		
		if(isNum(a) == true) {
			next = Integer.parseInt(a) + 3;
		}else if(isNum(b) == true) {
			next = Integer.parseInt(b) + 2;
		}else if(isNum(c) == true) {
			next = Integer.parseInt(c) + 1;
		}
		
		if(next % 15 == 0) {
			System.out.println("FizzBuzz");
		}else if(next % 3 == 0) {
			System.out.println("Fizz");
		}else if(next % 5 == 0) {
			System.out.println("Buzz");
		}else {
			System.out.println(next);
		}
	}
	
	public static boolean isNum(String s) {
		if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
			return true;
		}
		return false;
	}
}
