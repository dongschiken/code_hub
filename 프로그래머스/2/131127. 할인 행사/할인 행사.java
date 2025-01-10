import java.util.*;

class Solution {
    
    private static Map<String, Integer> map;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 일자별로 MAP에 넣어놓고, 꺼냈을 때 number와 동일한지 체크
        ONE:
        for(int i = 0; i <= discount.length - 10; i++) {
            doInsertMap(i, discount);
            for(int j = 0; j < want.length; j++) {
                if(map.get(want[j]) != null) {
                    // System.out.println(map.get(want[j]) + want[j]);
                    if(number[j] > map.get(want[j])) continue ONE;
                } else {
                    continue ONE;
                }
            }
            answer++;
        }
        return answer;
    }
    public static void doInsertMap(int currDate, String[] discount) {
        map = new HashMap<>();
        for(int i = currDate; i <=  currDate + 9; i++) {
            map.compute(
                discount[i], (K, V) -> V == null ? 1 : ++V
            );
        }
    }
}