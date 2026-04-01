import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] maxDP = new int[N][3];
        int[][] minDP = new int[N][3];
        int[][] arr = new int[N][3];
        
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        maxDP[0][0] = arr[0][0];
        maxDP[0][1] = arr[0][1];
        maxDP[0][2] = arr[0][2];
        
        minDP[0][0] = arr[0][0];
        minDP[0][1] = arr[0][1];
        minDP[0][2] = arr[0][2];
        
        for(int r = 1; r < N; r++) {
            maxDP[r][0] = Math.max(maxDP[r-1][0] + arr[r][0], maxDP[r-1][1] + arr[r][0]);
            maxDP[r][1] = Math.max(maxDP[r-1][0] + arr[r][1], maxDP[r-1][1] + arr[r][1]);
            maxDP[r][1] = Math.max(maxDP[r][1], maxDP[r-1][2] + arr[r][1]);
            maxDP[r][2] = Math.max(maxDP[r-1][1] + arr[r][2], maxDP[r-1][2] + arr[r][2]);
            
            
            minDP[r][0] = Math.min(minDP[r-1][0] + arr[r][0], minDP[r-1][1] + arr[r][0]);
            minDP[r][1] = Math.min(minDP[r-1][0] + arr[r][1], minDP[r-1][1] + arr[r][1]);
            minDP[r][1] = Math.min(minDP[r][1], minDP[r-1][2] + arr[r][1]);
            minDP[r][2] = Math.min(minDP[r-1][1] + arr[r][2], minDP[r-1][2] + arr[r][2]);
        }
        
        //System.out.println(Arrays.deepToString(maxDP));
        //System.out.println(Arrays.deepToString(minDP));
        
        int max = Math.max(Math.max(maxDP[N - 1][0], maxDP[N - 1][1]), maxDP[N - 1][2]);
        int min = Math.min(Math.min(minDP[N - 1][0], minDP[N - 1][1]), minDP[N - 1][2]);
        
        System.out.println(max + " " + min);
    }
}