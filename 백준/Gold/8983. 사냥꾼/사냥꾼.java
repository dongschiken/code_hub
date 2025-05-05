import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] sadas = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sadas[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sadas);
        int count = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(y > L) continue;
            int idx = Arrays.binarySearch(sadas, x);
            
            if(idx < 0) {
                idx = -(idx + 1);
                
                if(idx > 0 && idx < N) {
                    int l = x - sadas[idx - 1];
                    int r = sadas[idx] - x;
                    idx = l <= r ? idx - 1 : idx;
                }else if(idx == N) {
                    idx = N - 1;
                }
            }
            
            int dist = Math.abs(sadas[idx] - x) + y;
            
            if(dist <= L) {
                count++;
            }
            
        }
        System.out.println(count);
    }
}