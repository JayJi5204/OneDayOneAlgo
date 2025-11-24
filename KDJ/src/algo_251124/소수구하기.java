package algo_251124;
import java.util.Scanner;

public class 소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int cnt = 0;
        
        for (int i = M; i <= N;i++){
        	 boolean prime = true;
        	for(int j = 2;j < i; j++) {   
            	if(i%j == 0) {
            		prime = false;
            	}
        	}
        	if(prime == true) {
        		System.out.println(i);
        	}
        }
    }
}
