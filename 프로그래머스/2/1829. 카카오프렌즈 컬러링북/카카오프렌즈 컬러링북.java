import java.util.*;

class Solution {
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        // 1 1 1 0
        // 1 1 1 0
        // 0 0 0 1
        // 0 0 0 1
        // 0 0 0 1
        // 0 0 0 1
        // 10000
        // 0이 아닌 나머지 숫자들은 탐색
        // max값을 계속 초기화
        // 탐색한 원소는 0으로 변경
        int max = -1;
        int count = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(picture[r][c] != 0) {
                    max = Math.max(max, bfs(r, c, m, n, picture));
                    count++;
                }
            }
        }
        
        // max, count
        return answer = new int[]{count, max};
    }

    public static int bfs(int r, int c, int m, int n, int[][] picture) {
        int curr = picture[r][c];
        picture[r][c] = 0;
        int pCount = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        while(!q.isEmpty()) {
            int[] rc = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = rc[0] + dr[i];
                int nc = rc[1] + dc[i];
                if(check(nr, nc, m, n) && picture[nr][nc] == curr) {
                    q.offer(new int[]{nr, nc});
                    pCount++;
                    picture[nr][nc] = 0;
                }
            }
        }
        return pCount;
    }
    
    public static boolean check(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}