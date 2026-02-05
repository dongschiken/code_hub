import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] DP = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        DP[1] = arr[1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i / 2; j++) {
                DP[i] = Math.max(DP[i], DP[i-j] + DP[j]);
                DP[i] = Math.max(DP[i], arr[i]);
            }
        }
        System.out.println(DP[N]);
    }
}