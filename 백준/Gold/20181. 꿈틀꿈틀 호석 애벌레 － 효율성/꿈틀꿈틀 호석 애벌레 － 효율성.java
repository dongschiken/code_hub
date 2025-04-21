import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] sum = new int[N + 1];
        int[] DP = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 1;
        int cMax = 0;
        while(r <= N) {
            int minus = sum[r] - sum[l];
            
            if(minus >= K) {
                cMax = Math.max(cMax, DP[l]);
                DP[r] = Math.max(cMax + minus - K, DP[r]);
                l++;
            }else {
                r++;
            }
        }
        
        int answer = 0;
        for(int dp : DP) {
            answer = Math.max(dp, answer);
        }
        System.out.println(answer);
    }
}