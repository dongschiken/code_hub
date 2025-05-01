import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] min = new int[N];
        int[] max = new int[N];
        int[] sortMin = new int[N];
        int[] sortMax = new int[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            min[i] = a - b;
            max[i] = a + b;
            sortMin[i] = a - b;
            sortMax[i] = a + b;
        }
        
        // min은 max의 lowerbound
        // max는 min의 upperbound
        Arrays.sort(sortMin);
        Arrays.sort(sortMax);
        for(int i = 0; i < N; i++) {
            int up = upperbound(sortMin, max[i]);
            int lo = lowerbound(sortMax, min[i]);
            sb.append(lo + 1).append(" ").append(up).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int lowerbound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public static int upperbound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
}