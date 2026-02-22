import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        // set처럼 사용하기위한 list
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        // 결과 연산을 위한 list
        List<String> list1 = new ArrayList<>(); // 합
        List<String> list2 = new ArrayList<>(); // 교
        //System.out.println(str1);
        //System.out.println(str2);
        // System.out.println('A' - 65);
        // System.out.println('Z' - 65);
        
        // 2글자 파싱
        // map에 해당 2글자 갯수 count
        // set에 해당 2글자 중복되지 않게 넣기
        for(int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if(isEnglish(s)) {
                map1.compute(s, (k, v) -> (v == null) ? 1 : ++v);
                if(!set1.contains(s)) {
                    set1.add(s);
                }
            } else {
                continue;
            }
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            if(isEnglish(s)) {
                map2.compute(s, (k, v) -> (v == null) ? 1 : ++v);
                if(!set2.contains(s)) {
                    set2.add(s);
                }
            } else {
                continue;
            }
        }
        
        // System.out.println(set1);
        // System.out.println(set2);
        
        // 합집합 -> 1번 꺼내서 2번 집합에 포함된 경우 Math.max(map1value, map2value) 새 list1에 추가,
        //          포함 안된경우 map1value만큼 list1에 추가
        // 2번 집합에서 꺼낸값이 1번에 있는경우 pass, 없는경우 list2에 map2value만큼 추가
        for(int i = 0; i < set1.size(); i++) {
            if(set2.contains(set1.get(i))) {
                int max = Math.max(map1.get(set1.get(i)), map2.get(set1.get(i)));
                for(int j = 0; j < max; j++) {
                    list1.add(set1.get(i));
                }
            } else {
                for(int j = 0; j < map1.get(set1.get(i)); j++) {
                    list1.add(set1.get(i));
                }
            }
        }
        for(int i = 0; i < set2.size(); i++) {
            if(!set1.contains(set2.get(i))) {
                for(int j = 0; j < map2.get(set2.get(i)); j++) {
                    list1.add(set2.get(i));
                }
            }
        }
        // // 교집합 -> 1번 꺼내서 2번 집합에 포함된 경우 Math.min(map1value, map2value)
        // // 새 list2에 추가
        for(int i = 0; i < set2.size(); i++) {
            if(set1.contains(set2.get(i))) {
                int min = Math.min(map1.get(set2.get(i)), map2.get(set2.get(i)));
                for(int j = 0; j < min; j++) {
                    list2.add(set2.get(i));
                }
            }
        }
        System.out.println(list1);
        System.out.println(list2);
        if(list1.size() <= 0 && list2.size() <= 0) {
            answer = 1 * 65536;
        } else {
            double list1Size = list1.size();
            double list2Size = list2.size();
            double temp = (list2Size / list1Size) * 65536;
            answer = (int)Math.floor(temp);
        }
        return answer;
    }
    
    public static boolean isEnglish(String str) {
        boolean check = true;
        // 65를 뺀 값이 0 ~ 25사이에 들어오면 영문자
        for(int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i) - 65 >= 0 && str.charAt(i) - 65 < 26)) {
                check = false;
            }
        }
        return check;
    }
}