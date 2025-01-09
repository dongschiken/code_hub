import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 12, 34, 56, 78 1round
        // 1 , 2 , 3 , 4
        // 12, 34 2round
        // 1 , 2
        // 12 3round
        
        // 1, 5
        // A - B = 1; break
        // 오른쪽 인덱스를 / 2 한값을 새로운 값으로 넣는다.
        // 짝수면 건들지 말고, 홀수면 + 1해준다.
        
        int count = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while(max - min >= 1) {
            if(max % 2 == 0) {
                max /= 2;
            }else {
                max = (max + 1) / 2;
            }
            if(min % 2 == 0) {
                min /= 2;
            }else {
                min = (min + 1) / 2;
            }
            count++;
        }

        return count;
    }
}