import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        Arrays.sort(citations);
        for(int i = 1; i <= length; i++) {
            // index 1 2 3 4 5
            // 0 1 3 5 6
            int count = 0;
            for(int j = 0; j < length; j++) {
                if(citations[j] >= i) {
                    count++;
                }
            }
            if(count >= i) {
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}