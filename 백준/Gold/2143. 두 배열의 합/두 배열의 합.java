import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Integer.parseInt(br.readLine());
        // A, B의 최대 부분합 = 499,500
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        // bsum, asum도 누적합 구할 때 int 초과할 수 있어서 long으로 선언
        long[] asum = new long[((N * (N - 1)) / 2) + N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        // 누적합
        for(int i = 0; i < N; i++) {
            long currentSum = 0;
            for(int j = i; j < N; j++) {
                currentSum += a[j];
                asum[count++] = T - currentSum;
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[M];
        long[] bsum = new long[((M * (M - 1)) / 2) + M];
        for(int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        // 누적합
        for(int i = 0; i < M; i++) {
            long currentSum = 0;
            for(int j = i; j < M; j++) {
                currentSum += b[j];
                bsum[count++] = currentSum;
            }
        }
        Arrays.sort(bsum);
        
        // 최대 결과가 500000 * 500000이면 int범위를 초과한다. -> long으로 선언
        long result = 0;
        for(int i = 0; i < asum.length; i++) {
            int lo = lowerbound(bsum, asum[i]);
            int up = upperbound(bsum, asum[i]);
            result += up - lo;
        }
        System.out.println(result);
    }
    
    public static int lowerbound(long[] arr, long target) {
        int l = 0;
        int r = arr.length - 1;
        
        while(l <= r) {
            int mid = (r + l) / 2;
            
            if(arr[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    public static int upperbound(long[] arr, long target) {
        int l = 0;
        int r = arr.length - 1;
        
        while(l <= r) {
            int mid = (r + l) / 2;
            
            if(arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}