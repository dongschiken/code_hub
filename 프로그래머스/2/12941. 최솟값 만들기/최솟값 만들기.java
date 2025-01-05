import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        List<Integer> list = new ArrayList<>();    
        Arrays.sort(A);
        for(int i = 0; i < B.length; i++) {
            list.add(B[i]);
        }
        Collections.sort(list, Comparator.reverseOrder());
        for(int i = 0; i < B.length; i++) {
            B[i] = list.get(i);
        }
        // 1 2 4
        // 5 4 4
        // 4 4 5
        // 4 2 1
        for(int i = 0; i < A.length; i++) {
            answer += B[i] * A[i];    
        }
        return answer;
    }
}