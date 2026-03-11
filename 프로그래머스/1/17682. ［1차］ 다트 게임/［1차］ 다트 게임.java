import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        //
        List<String> list = new ArrayList<>();
        list.add("S");
        list.add("D");
        list.add("T");
        for(int i = 0; i < dartResult.length(); i++) {
            if(list.contains(dartResult.substring(i, i + 1))) {
                int score = 0;
                if(dartResult.substring(i - 1, i).equals("0")) {
                    // 10또는 0
                    if(i - 1 > 0 && dartResult.substring(i - 2, i - 1).equals("1")) {
                        score = Integer.parseInt(dartResult.substring(i - 2, i));
                    }
                } else{
                    score = Integer.parseInt(dartResult.substring(i - 1, i));
                }
                score = calculateBonus(score, dartResult.substring(i, i + 1));
                // System.out.println(score);
                if(i != dartResult.length() - 1
                   && ((dartResult.substring(i + 1, i + 2).equals("*") || dartResult.substring(i + 1, i + 2).equals("#")))) {
                    // System.out.println("##$#$#$");
                    if(dartResult.substring(i + 1, i + 2).equals("*")) {
                        if(map.get(count - 1) != null) {
                            
                            map.put(count - 1, map.get(count - 1) * 2);
                        }
                        score *= 2;
                    } else {
                        score *= -1;
                    }
                }
                map.put(count++, score);
            }
        }
        return answer = map.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    public static int calculateBonus(int originScore, String bonus) {
        if(bonus.equals("D")) {
            return originScore *= originScore;
        } else if(bonus.equals("T")) {
            return originScore *= originScore * originScore; 
        }
        return originScore;
    }
}