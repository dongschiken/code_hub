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
        dp[1][1] = arr[1];
        for(int i = 2; i <= N; i++) {
            // 1개 전 0
            dp[i][0] = dp[i - 1][1] + arr[i];
            // 2개 전 1
            dp[i][1] = Math.max(dp[i - 2][0] + arr[i], dp[i - 2][1] + arr[i]);
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}