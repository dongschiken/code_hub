import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        //Arrays.sort(arr);
        int l = 0;
        int r = 2;
        if(max >= M) {
            System.out.println(1);
            return;
        }
        long sum = arr[0] + arr[1];
        int min = Integer.MAX_VALUE;
        while(r <= N) {
            // 당겨질땐 -l
            // 밀어낼땐 +r
            if(sum >= M) {
                min = Math.min(min, r - l);
            }
            if(sum > M) {
                sum -= arr[l++];
            } else {
                sum += arr[r++];
            }
        }
        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(min);
    }
}