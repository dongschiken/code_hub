import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N * (N - 1) / 2];
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        // 1
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i);
            if(M == arr[i]) {
                System.out.println(1);
                return;
            }
        }
        
        // 2
        int idx = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                sum[idx++] = arr[i] + arr[j];
                if(sum[idx - 1] == M) {
                    System.out.println(1);
                    return;
                }
                if(map.get(M - sum[idx - 1]) != null) {
                    if(map.get(M - sum[idx - 1]) != i && map.get(M - sum[idx - 1]) != j) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(0);
        
    }
}