import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N];
            int[][] arr = new int[2][N];
            
            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(N == 1) {
                sb.append(Math.max(arr[0][0], arr[1][0])).append("\n");
                continue;
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = arr[0][1] + dp[1][0];
            dp[1][1] = arr[1][1] + dp[0][0];
            if(N == 2) {
                sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
                continue;
            }

            for(int i = 2; i < N; i++) {
                dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
            
            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
        }
        System.out.println(sb);
    }
}