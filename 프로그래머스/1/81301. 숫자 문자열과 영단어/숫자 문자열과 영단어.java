import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        init(map);
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.substring(i, i+1));
                Integer v = map.get(sb.toString());
                if(v != null) {
                    temp += v.toString();
                    sb = new StringBuilder();
                }
            } else {
                temp += s.substring(i, i+1);
            }
        }
        //System.out.println(temp);
        return answer = Integer.parseInt(temp);
    }
    
    public static void init(Map<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}