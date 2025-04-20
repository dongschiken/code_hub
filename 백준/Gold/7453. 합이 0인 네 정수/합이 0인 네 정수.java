import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        
        int[] arr = new int[N * N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[idx++] = A[i] + B[j];
            }
        }
        
        Arrays.sort(arr);
        long count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int target = (C[i] + D[j]) * -1;
                int lo = lowerbound(arr, target);
                int up = upperbound(arr, target);
                count += up - lo;
            }
        }
        
        System.out.println(count);
    }
    
    public static int lowerbound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public static int upperbound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}