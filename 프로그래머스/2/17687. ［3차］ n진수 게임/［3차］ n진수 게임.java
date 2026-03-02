import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        int num = 0;
        while(sb.length() < m * t) {
            sb.append(changeNum(n, num++, map));
        }
        int count = 0;
        String str = sb.toString();
        sb = new StringBuilder();
        for(int i = 0; count < t; i++) {
            // System.out.println((i % m) == p - 1);
            if((i % m) == (p - 1)) {
                sb.append(str.substring(i, i + 1));
                count++;
            }
        }
        return answer = sb.toString();
    }
    
    // 진수 변환
    public String changeNum(int n, int m, Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        while(m > 0) {
            int num = m % n;
            m = m / n;
            if(num > 9) {
                sb.append(map.get(num));
            } else {
                sb.append(String.valueOf(num));
            }
        }
        sb.reverse();
        return sb.toString();
    }
}