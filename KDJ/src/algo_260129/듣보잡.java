package algo_260129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 듣보잡 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> names = new HashSet<String>();
		List<String> output = new ArrayList<String>();
		
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			names.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(names.contains(name)) {
				output.add(name);
			}else {
				continue;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(output.size()).append('\n');
		
		Collections.sort(output);
		
		for(int i = 0; i < output.size(); i++) {
			sb.append(output.get(i)).append('\n');
		}	
		System.out.println(sb);
	}
}