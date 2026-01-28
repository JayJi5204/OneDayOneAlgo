package algo_260128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer nums = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(nums.nextToken());
		int M = Integer.parseInt(nums.nextToken());
		
		String[] pokemons = new String[N+1];
		HashMap<String, Integer> index = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			
			String name = br.readLine();
			pokemons[i] = name;
			index.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			
			String question = br.readLine();
			char check = question.charAt(0);
			
			if(check >= '0' && check <= '9' ) {
				sb.append(pokemons[Integer.parseInt(question)]).append("\n");
			}else {
				sb.append(index.get(question)).append("\n");
			}
		}
		System.out.println(sb);
	}
}