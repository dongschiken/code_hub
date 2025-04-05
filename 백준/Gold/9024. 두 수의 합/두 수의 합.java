import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long[] arr = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(arr);
            int left = 0;
            int right = N-1;
            long minLength = Long.MAX_VALUE;
            int count = 0;
            while(left < right) {
                long sum = arr[left] + arr[right];
                long minus = Math.abs(sum - M);
                if(minLength > minus) {
                    minLength = minus;
                    count = 1;
                } else if(minus == minLength) {
                    count++;
                }
                if(sum >= M) {
                    right--;
                }else {
                    left++;
                }
            }
            System.out.println(count);
        }
    }
}