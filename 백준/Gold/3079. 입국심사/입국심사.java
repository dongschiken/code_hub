import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long maxTime = 0L;
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, arr[i]);
        }
        
        long l = 1;
        long r = maxTime * M;
        long mid = 0;
        while(l <= r) {
            mid = l + (r - l) / 2;
            
            long count = 0;
            for(int i = 0; i < N; i++) {
                count += mid / arr[i];
                if(count >= M) break;
            }
            
            if(count < M) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
}