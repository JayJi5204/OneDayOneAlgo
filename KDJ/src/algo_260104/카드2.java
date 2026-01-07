package algo_260104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> cards = new ArrayDeque<Integer>();
		
		for(int i = 0; i < N; i++) {
			cards.add(i+1);
		}
		
		while(cards.size() > 1) {
			cards.poll();
			cards.addLast(cards.poll());
		}	
		System.out.println(cards.peek());
	}
}