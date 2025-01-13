import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.compute(clothes[i][1],
                   (K, V) -> V == null ? 1 : ++V
                   );
        }
        for(Integer i : map.values()) {
            answer *= i + 1;
        }
        return answer - 1;
    }
}