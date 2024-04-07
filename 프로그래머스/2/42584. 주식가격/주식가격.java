import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
     ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			deque.offer(prices[i]);
		}
		OUT :
		for (int i = 0; i < prices.length; i++) {
			int count = 0;
			int now_price = deque.poll();
			for (int j = 0; j < deque.size(); j++) {
				count++;
				if( prices[j+i+1] >= now_price ) {
					answer[i] = count;			
					
				}else if( prices[j+i+1] < now_price) {
					answer[i] = count;		
					continue OUT;
				}
			}
		}
		return answer;
	}
}
