package algo_251228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나이순정렬 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] bucket = new StringBuilder[201];
        
        for (int i = 1; i <= 200; i++) bucket[i] = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int age = Integer.parseInt(st.nextToken());
            
            String name = st.nextToken();
            
            bucket[age].append(age).append(' ').append(name).append('\n');
        }

        StringBuilder ans = new StringBuilder();
        
        for (int i = 1; i <= 200; i++) {
        	ans.append(bucket[i]);
        }
        System.out.print(ans);
    }
}
