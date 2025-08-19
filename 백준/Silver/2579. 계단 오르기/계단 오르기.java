import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if(N == 1) {
            System.out.println(arr[1]);
            return;
        }
        
        dp[1][0] = arr[1];
        dp[2][0] = arr[2];
        dp[2][1] = dp[1][0] + arr[2];
        //System.out.println(dp[1][0] + ", " + dp[1][1]);
        //System.out.println(dp[2][0] + ", " + dp[2][1]);
        for(int i = 3; i <= N; i++) {
            // 2칸 점프 i - 2 1
            // 1칸 점프 i - 1 0
            dp[i][0] = Math.max(dp[i - 2][1] + arr[i],dp[i - 2][0] + arr[i]);
            dp[i][1] = dp[i - 1][0] + arr[i];
            //System.out.println(dp[i][0] + ", " + dp[i][1]);
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}