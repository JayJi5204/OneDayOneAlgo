package algo_251208;

import java.util.Scanner;

public class Hashing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		String L = sc.next();
		
		char[] digit = new char[length];
		
		int M = 1234567891;
		
		for(int i = 0; i <length;i++) {
			digit[i] = L.charAt(i);
		}
		
		Long ans = 0L;
		Long r = 1L;
		
		for(int i = 0; i < length; i++) {
			int hashed = (digit[i]-'a'+1);
			ans = (ans + hashed * r)% M;
			r = (r *31) % M;
		}
		
		System.out.println(ans);
	}

}
