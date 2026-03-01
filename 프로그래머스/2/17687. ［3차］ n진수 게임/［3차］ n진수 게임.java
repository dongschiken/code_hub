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
        // 0으로 시작
        StringBuilder sb = new StringBuilder("0");
        int num = 1;
        while(sb.length() < t * m) {
            sb.append(convert(num++, n, map));
        }
        // System.out.println(sb.toString());
        String str = sb.toString();
        sb = new StringBuilder();
        int count = 0;
        for(int i = 0; count < t; i++) {
            if((i % m) == p - 1) {
                sb.append(str.substring(i, i + 1));
                count++;
            }
        }
        // System.out.println(sb.toString());
        return answer = sb.toString();
    }
    
    public String convert(int n, int m, Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int x = n % m;
            n = n / m;
            if(x > 9) {
                sb.append(map.get(x));
            } else {
                sb.append(String.valueOf(x));
            }
        }
        sb.reverse();
        // System.out.println(sb.toString());
        return sb.toString();
    }
}