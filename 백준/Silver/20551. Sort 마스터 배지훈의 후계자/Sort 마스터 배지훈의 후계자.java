import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(arr);
        for(int i = 0; i < M; i++) {
            long target = Integer.parseInt(br.readLine());
            
            int idx = Arrays.binarySearch(arr, target);
            if(idx < 0) {
                sb.append(-1).append("\n");
            }else {
                sb.append(lowerbound(arr, target)).append("\n");
            }
        }
        System.out.println(sb);
    }
    
    public static int lowerbound(long[] arr, long target) {
        int l = 0;
        int r = arr.length;
        
        while(l <= r) {
            int mid = (r + l) / 2;
            
            if(arr[mid] >= target) {
                // 1 2 3 3
                // 1
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}