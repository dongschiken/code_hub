import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            
            int l = 0;
            int r = N - 1;
            
            int cnt = 0;
            while(l < r && l < N) {
                int sum = arr[l] + arr[r];
                
                if(sum == M) {
                    cnt++;
                }
                if(sum > M) {
                    r--;
                } else {
                    l++;
                }
            }
            sb.append("Case #").append(t+1).append(": ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}