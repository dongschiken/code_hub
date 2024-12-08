import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<String> result = new ArrayList<>();
    static int cnt;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length + 1];
        cnt = tickets.length;
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        return result.get(0).split(" ");
    }
    
    public static void dfs(int stage, String start, String path, String[][] tickets) {
        if(stage == cnt){
            result.add(path);
            return;
        }
        
        for(int i = 0; i < cnt; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(stage+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}