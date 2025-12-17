package algo_251217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBN {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		char[] letters = new char[input.length()];
		
		for(int i = 0; i<letters.length; i++) {
			letters[i] = input.charAt(i);
		}
		
		int sum = 0;
		int place = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(i%2 == 0) {
				if(letters[i] == '*' ) {
					place = i;
					continue;
				}else {
					sum += (letters[i] - '0');
				}
			}else if(i%2 == 1) {
				if(letters[i] == '*' ) {
					place = i;
					continue;
				}else {
					sum += ((letters[i] - '0')*3);
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 0; i < 10; i++) {
			if(place%2 == 0) {
				sum += i;
			}else if(place%2 == 1){
				sum += i*3;
			}
			
			if(sum%10 == 0) {
				ans = i;
				break;
			}
		}
	System.out.println(ans);	
	}
}
