import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // for i -> n
        //     for j -> i
        // arr[i] > arr[j] 
        // dp[i] = Math.max(dp[i], dp[j] + 1)
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = -1;
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}