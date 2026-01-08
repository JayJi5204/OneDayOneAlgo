package Jan;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 숫자카드2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int[] positiveArr = new int[10000001];
        int[] negativeArr = new int[10000001];


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) {
                positiveArr[num]++;
            } else {
                negativeArr[Math.abs(num)]++;
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            if (target >= 0) {
                sb.append(positiveArr[target]).append(" ");
            } else {
                sb.append(negativeArr[Math.abs(target)]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}