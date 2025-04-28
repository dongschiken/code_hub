import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        // 1
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(M == arr[i]) {
                System.out.println(1);
                return;
            }
        }
        
        Arrays.sort(arr);
        // 2
        int idx = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];
                if(sum == M) {
                    System.out.println(1);
                    return;
                }
                // 이분탐색 진행해서 값이 나왔을 때 i != j != 
                int index = binarysearch(N, arr, M - sum);
                if(index != i && index != j && index != -1) {
                    System.out.println(1);
                    return;
                }
            }
        }
        
        System.out.println(0);
        
    }
    
    public static int binarysearch(int N, int[] arr, int target) {
        int l = 0;
        int r = N - 1;
        while(l < r) {
            int mid = (r + l) / 2;
            
            if(target == arr[mid]) {
                return mid;
            }
            if(target < arr[mid]) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}