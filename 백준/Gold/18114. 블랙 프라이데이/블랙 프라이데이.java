import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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
                int sum = arr[i] + arr[j];
                if(sum == M) {
                    System.out.println(1);
                    return;
                }
                if(map.get(M - sum) != null) {
                    if(map.get(M - sum) != i && map.get(M - sum) != j) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(0);
        
    }
}