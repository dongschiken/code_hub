import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cacheMemory = new ArrayList<>();
        
        for(int i = 0; i < cities.length; i++) {
            int length = Math.min(cacheMemory.size(), cacheSize);
            int idx = -1;
            for(int j = 0; j < cacheMemory.size(); j++) {
                if((cacheMemory.get(j).toUpperCase()).equals((cities[i]).toUpperCase())) {
                    idx = j;
                }
            }
            if(cacheSize == 0) {
                answer += 5;
                continue;
            }
            if(idx == -1) {
                answer += 5;
                if(cacheMemory.size() >= cacheSize) {
                    cacheMemory.remove(0);
                }
                cacheMemory.add(cities[i]);
            } else {
                answer++;
                cacheMemory.remove(idx);
                cacheMemory.add(cities[i]);
            }
            
        }
        return answer;
    }
}