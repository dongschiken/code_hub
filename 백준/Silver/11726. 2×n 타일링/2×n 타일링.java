import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1002];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 1001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}