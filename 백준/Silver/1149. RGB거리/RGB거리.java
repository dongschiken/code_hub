import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        DP[0][0] = Integer.parseInt(st.nextToken());
        DP[0][1] = Integer.parseInt(st.nextToken());
        DP[0][2] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            DP[i][0] = Math.min(r + DP[i - 1][1], r + DP[i - 1][2]);
            DP[i][1] = Math.min(g + DP[i - 1][0], g + DP[i - 1][2]);
            DP[i][2] = Math.min(b + DP[i - 1][0], b + DP[i - 1][1]);
        }
        
        int result = Math.min(DP[N - 1][0], DP[N - 1][1]);
        result = Math.min(result, DP[N - 1][2]);
        System.out.println(result);
    }
}