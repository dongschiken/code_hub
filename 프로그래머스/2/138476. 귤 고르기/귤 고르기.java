import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] countArray = new int[tangerine[tangerine.length - 1] + 1];
        for(int i = 0; i < tangerine.length; i++) {
            countArray[tangerine[i]]++;
        }
        Arrays.sort(countArray);
        for(int i = countArray.length - 1; i >= 0; i--) {
            if(countArray[i] == 0) break;
            if(countArray[i] < k) {
                k = k - countArray[i];
                answer++;
            }else {
                answer++;
                break;
            }
        }
        return answer;
    }
}