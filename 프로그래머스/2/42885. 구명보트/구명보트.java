import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lastIdx = people.length - 1;
        int firstIdx = 0;
        for(int i = lastIdx; i >= firstIdx; i--) {
            if(people[firstIdx] + people[i] <= limit) {
                firstIdx++;
            }
            answer++;
        }
        return answer;
    }
}