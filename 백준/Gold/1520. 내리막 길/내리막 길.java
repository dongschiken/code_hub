import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[][] dp, map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        map = new int[N][M];
        
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        System.out.println(dfs(0, 0));
    }
    public static int dfs(int r, int c) {
        if(r == N - 1 && c == M - 1) {
            return 1;
        }
        
        // 이미 경로가 탐색된 곳은 해당위치값 반환
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        dp[r][c] = 0;
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            // N -1, M -1에 도착한 경로 모두 sum
            if(!(nr >= 0 && nr < N && nc >= 0 && nc < M)) continue;
            if(map[r][c] > map[nr][nc]) {
                dp[r][c] += dfs(nr, nc);
            }
        }
        
        return dp[r][c];
    }
}