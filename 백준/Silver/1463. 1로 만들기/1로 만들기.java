import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        // 1 ~ N 까지
        // 1은 이미 0 -> 2부터 시작
        // dp[2] = dp[1] + 1; dp[2] = 0 + 1
        // dp[2] = Math.min(dp[2 / 2] + 1, dp[2]); dp[2] = Math.min(0 + 1, 1);
        
        // dp[3] = dp[2] + 1; dp[3] = 1 + 1;
        // dp[3] = Math.min(dp[3 / 3] + 1, dp[3]); dp[3] = Math.min(0 + 1, 2);
        
        // dp[4] = dp[3] + 1; dp[4] = 1 + 1;
        // dp[4] = Math.min(dp[4 / 2] + 1, dp[4]); dp[4] = Math.min(1 + 1, 2);
        
        // dp[5] = dp[4] + 1; dp[5] = 2 + 1;
        
        // dp[6] = dp[5] + 1; dp[6] = 3 + 1;
        // dp[6] = Math.min(dp[6 / 2] + 1, dp[6]); dp[6] = Math.min(2 + 1, 4);
        // dp[6] = Math.min(dp[6 / 3] + 1, dp[6]); dp[6] = Math.min(1 + 1, 3);
        
        // dp[N] = 2; 6일때
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
            
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}