import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = 1;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(map[r][c] == 0) continue;
                if(r == N - 1 && c == N - 1) continue;
                int jumpCnt = map[r][c];
                
                if(jumpCnt + c < N) {
                    dp[r][jumpCnt + c] += dp[r][c];
                }
                if(jumpCnt + r < N) {
                    dp[jumpCnt + r][c] += dp[r][c];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}