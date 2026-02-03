import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[] dp = new long[N];
        
        String[] str = br.readLine().split(" ");
        long max = -1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            max = Math.max(arr[i], max);
        }
        //System.out.println(Arrays.toString(arr));
        
        for(int i = 0; i < N; i++) {
            dp[i] = arr[i];
            
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(max);
    }
}