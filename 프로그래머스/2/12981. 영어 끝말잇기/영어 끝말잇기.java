import java.util.*;
import java.util.Set.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int[] countMap = new int[n + 1];
        Set<String> set = new HashSet<>();
        int wl = words.length;
        countMap[1]++;
        set.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            int now = i % n + 1;
            if(words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1)) {
                if(set.contains(words[i])) {
                    return answer = new int[]{now, ++countMap[now]};
                }else {
                    countMap[now]++;
                    set.add(words[i]);
                }
            } else {
                return answer = new int[]{now, ++countMap[now]};
            }
        }
        return answer;
    }
}