import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] countArr = new int[d + 1];
        int count = 0;
        for(int i = 0; i < k; i++) {
            if(countArr[arr[i]] == 0) count++;
            countArr[arr[i]]++;
        }
        int max = count;
        if(countArr[c] == 0) max++;
        
        for(int i = 0; i < N - 1; i++) {
            
            countArr[arr[i]]--;
            if(countArr[arr[i]] == 0) {
                count--;
            }
            
            if(countArr[arr[(i + k) % N]] == 0) {
                count++;
            }
            countArr[arr[(i + k) % N]]++;
            
            if(countArr[c] == 0) {
                max = Math.max(count + 1, max);
            }else {
                max = Math.max(count, max);
            }
        }
        System.out.println(max);
    }
}