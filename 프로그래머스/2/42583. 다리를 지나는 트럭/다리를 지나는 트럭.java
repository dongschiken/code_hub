import java.util.ArrayDeque;
import java.util.*;
import java.io.*;
class Solution {
 
    
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
       int answer = 0;
        ArrayDeque<Integer> start_deque = new ArrayDeque<Integer>();
        ArrayDeque<int[]> bridge = new ArrayDeque<int[]>();
        ArrayDeque<Integer> end_deque = new ArrayDeque<Integer>();



        for (int i = 0; i <  truck_weights.length; i++) {
            start_deque.offer(truck_weights[i]);
        }
        int second = 0;
        int temp = 0;
        int s_size = start_deque.size();
        while(s_size != end_deque.size()){

            if( start_deque.size() != 0){
                temp = start_deque.poll();
            }
            int temp_deque = temp;
            int b_size = bridge.size();
            while( b_size > 0 ){
                int[] bridgeCar = bridge.poll();
                temp += bridgeCar[0];
                bridgeCar[1]++;
                if(bridgeCar[1] >= bridge_length ){
                    end_deque.offer(bridgeCar[0]);
                }else{
                    bridge.offer(new int[] {bridgeCar[0], bridgeCar[1] });
                }

                b_size--;
            }
            second++;
            if( temp > weight) {
                start_deque.offerFirst( temp_deque );
                continue;
            }
            bridge.offer(new int[]{temp_deque, 1});



        }
        return answer = second+1;
    }
}

