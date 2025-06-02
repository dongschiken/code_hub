import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] DP = new int[10001];
        DP[0] = 1;
        
        int[] arr = {1, 2, 3};
        for(int a : arr) {
            for(int i = a; i < 10001; i++) {
                DP[i] += DP[i - a];
            }
        }
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(DP[t]).append("\n");
        }
        System.out.println(sb);
    }
}