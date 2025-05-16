import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        // 2 11 14 17 21 25
        // 
        // 2
        // 0 - 2 - 9 - 3 - 4 - 4
        // 바위가 사라진 갯수 체크
        // 11 - 6 - 4 - 4 바위 2개 체크
        Arrays.sort(rocks);
        long l = 1;
        long r = distance;
        while(l <= r) {
            long mid = (r + l) / 2;
            
            int prev = 0;
            int count = 0;
            for(int i = 0; i < rocks.length; i++) {
                int minus = rocks[i] - prev;
                if(minus < mid) {
                    count++;
                } else {
                    prev = rocks[i];
                }
            }
            if(distance - prev < mid) {
                count++;
            }
            
            if(count > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        answer = (int)r;
        return answer;
    }
}