import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 1;
        for(int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)(65 + i)), count++);
        }
        
        String str = "";
        for(int i = 0; i < msg.length(); i++) {
            str += msg.substring(i, i + 1);
            System.out.println(str);
            if(map.get(str) != null) {
                continue;
            } else {
                list.add(map.get(str.substring(0, str.length() - 1)));
                map.put(str, count++);
                str = "";
                i--;
            }
        }
        if(!str.equals("")) {
            list.add(map.get(str));
        }
        //System.out.println(list);
        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
    
}