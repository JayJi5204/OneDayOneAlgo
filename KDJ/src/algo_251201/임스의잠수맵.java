package algo_251201;

import java.util.Scanner;

public class 임스의잠수맵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int event = sc.nextInt();
		int meditation = sc.nextInt();
		int vip = sc.nextInt();
		
		int no_of_med = sc.nextInt();
		int no_of_vip = sc.nextInt();
		
		int level = sc.nextInt();
		
		int exp = (250 - level)*100;
		
		int cnt = 0;
		
		while(exp > 0) {
			for(int i = 0; i < no_of_vip*30; i++) {
				
				if(exp <= 0) break;
				
				exp -= vip;
				cnt ++;
			}
			
			for(int i = 0; i < no_of_med*30; i++) {
				
				if(exp <= 0) break;
				
				exp -= meditation;
				cnt++;
			}
			
			for(int i = 0; i < Integer.MAX_VALUE; i++) {
				
				if(exp <= 0) break;
				
				exp -= event;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
