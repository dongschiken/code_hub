import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String temp = s.substring(1, s.length() - 1);
        Map<Integer, String[]> map = new HashMap<>();
        // 리스트를 set처럼 사용
        List<Integer> set = new ArrayList<>();
        temp = temp.replace("},{", "} {");
        temp = temp.replace("}", "");
        temp = temp.replace("{", "");        
        String[] strArr = temp.split(" ");
        // System.out.println(Arrays.toString(strArr));
        // System.out.println(strArr.length);
        
        for(int i = 0; i < strArr.length; i++) {
            String[] ss = strArr[i].split(",");
            map.put(ss.length, ss);
        }
        //System.out.println(map);
        
        for(int i = 1; i <= strArr.length; i++) {
            String[] sss = map.get(i);
            for(int j = 0; j < sss.length; j++) {
                if(!set.contains(Integer.parseInt(sss[j]))) {
                    set.add(Integer.parseInt(sss[j]));
                }
            }
        }
        //System.out.println(set);
        answer = new int[set.size()];
        for(int i = 0; i < set.size(); i++) {
            answer[i] = set.get(i);
        }
        return answer;
    }
}