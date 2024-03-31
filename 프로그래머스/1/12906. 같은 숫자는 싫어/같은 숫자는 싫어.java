import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       int[] answer = {};
         ArrayList<Integer> list = new ArrayList<Integer>();
         int temp = arr[0];
         list.add(temp);
         for(int i = 0; i < arr.length; i++){
             if( temp != arr[i] ){
                 temp = arr[i];
                 list.add(temp);
             }
         }
         answer = new int[list.size()];
         for(int i = 0; i < list.size(); i++) {
        	 answer[i] = list.get(i);
        	 
         }

         return answer;
    }
}