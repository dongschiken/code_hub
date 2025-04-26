import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        
        int l = 0;
        int r = max;
        int result = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            if(isPossible(arr, mid, M)) {
                result = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
    
    public static boolean isPossible(int[] arr, int mid, int M) {
        int min = arr[0];
        int max = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            int newMin = Math.min(min, arr[i]);
            int newMax = Math.max(max, arr[i]);
            
            if(newMax - newMin > mid) {
                count++;
                min = arr[i];
                max = arr[i];
            }else {
                min = newMin;
                max = newMax;
            }
            
            if(count > M) {
                return false;
            }
        }
        return true;
    }
    
}