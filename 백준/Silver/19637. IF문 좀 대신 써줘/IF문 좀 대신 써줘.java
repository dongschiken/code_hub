import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] strs = new String[N];
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            strs[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int idx = Arrays.binarySearch(arr, target);
            if(idx >= 0) {
                idx = lowerbound(arr, target);
                sb.append(strs[idx]).append("\n");
            } else {
                idx = Math.abs(idx + 1);
                sb.append(strs[idx]).append("\n");
            }
        }
        System.out.print(sb);
    }
    public static int lowerbound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while(l <= r) {
            int mid = (r + l) / 2;

            if(arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}