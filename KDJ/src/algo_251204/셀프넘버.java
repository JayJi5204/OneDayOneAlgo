package algo_251204;

public class 셀프넘버 {

	public static void main(String[] args) {
		
		boolean[] not = new boolean[10001];
		
		for(int i = 0; i <= 10000; i++) {
			
			String num = String.valueOf(i);
			int L = num.length();
			
			int sum = i;
			
			for(int j = 0; j < L; j++) {
				sum += num.charAt(j) - '0';
			}
			
			if(sum <= 10000) {
				not[sum] = true;
			}
		}
		for(int i = 1;i <= 10000; i++ ) {
			if(!not[i]) {
				System.out.println(i);
			}
		}
	}
}
