import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long Z = (long)((M * 100) / N);
        int l = 0;
        int r = 1_000_000_000;
        int min = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            long remain = (long)(((M + mid) * 100) / (N + mid));
            if(remain > Z) {
                r = mid - 1;
                min = Math.min(min, mid);
            } else {
                l = mid + 1;
            }
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }
}