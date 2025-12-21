package algo_251219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Set<String> inputs = new HashSet<>();
		
		for(int i = 0 ; i < N; i++) {
			inputs.add(br.readLine());
		}
		
		List<String> outputs = new ArrayList<>(inputs);
		
		outputs.sort(단어정렬::compare);
		
		for(int i = 0; i < outputs.size(); i++) {
			System.out.println(outputs.get(i));
		}
	
	}
	
	static public int compare(String a, String b) {
		if(a.length() != b.length()) {
			return a.length() - b.length();
		}
		return a.compareTo(b);
	}
}
