import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] counts = new int[100001];
        int[] arr = new int[N];
        int max = 1;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(arr));
        
        int s = 0;
        int e = 0;
        int cnt = 0;
        while(s <= e && e < N) {
            if(counts[arr[e]] + 1 > M) {
                counts[arr[s]]--;
                cnt--;
                s++;
            } else {
                counts[arr[e]]++;
                cnt++;
                e++;
            }
            
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}