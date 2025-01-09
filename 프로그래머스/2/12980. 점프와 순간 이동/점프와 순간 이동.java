import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        // 5007이라면?
        // 5000 + 7 = 12
        // 4000
        // 5000 2500 1250 625 624 312 156 78 39 38 19 18 9 8 4 2 1
        // 5 4 2 1
        int count = 0;
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            }else {
                count++;
                n -= 1;
            }
        }
        count += 1;
        return count;
    }
}