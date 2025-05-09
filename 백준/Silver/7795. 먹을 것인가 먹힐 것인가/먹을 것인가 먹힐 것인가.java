import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] as = new int[A];
            int[] bs = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < A; i++) {
                as[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < B; i++) {
                bs[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(bs);
            
            int count = 0;
            for(int i = 0; i < A; i++) {
                int idx = Arrays.binarySearch(bs, as[i]);
                
                if(idx >= 0) {
                    count += lowerbound(bs, as[i]);
                } else {
                    //System.out.println(idx);
                    //System.out.println(-1 * (idx + 1));
                    count += -1 * (idx + 1);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int lowerbound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        
        while(l < r) {
            int mid = (l + r) / 2;
            
            if(arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}