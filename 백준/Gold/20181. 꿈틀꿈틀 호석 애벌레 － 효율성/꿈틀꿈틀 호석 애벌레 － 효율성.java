import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[] sum = new long[N + 1];
        long[] DP = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }
        int l = 0;
        int r = 1;
        long cMax = 0;
        while(r <= N) {
            long minus = sum[r] - sum[l];
            
            if(minus >= K) {
                cMax = Math.max(cMax, DP[l]);
                DP[r] = Math.max(cMax + minus - K, DP[r]);
                l++;
            }else {
                r++;
            }
        }
        
        long answer = 0;
        for(long dp : DP) {
            answer = Math.max(dp, answer);
        }
        System.out.println(answer);
    }
}