import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        int[] a = new int[N / 2];
        int[] b = new int[N / 2];
        for(int i = 0; i < N / 2; i++) {
            a[i] = Integer.parseInt(br.readLine());
            b[i] = Integer.parseInt(br.readLine());
        }
        
        int[] count = new int[M + 1];
        // 석순
        for(int i = 0; i < N / 2; i++) {
            count[1]++;
            count[a[i] + 1]--;
        }
        
        // 종유석
        for(int i = 0; i < N / 2; i++) {
            count[M - b[i] + 1]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            min = Math.min(count[i], min);
        }
        
        int result = 0;
        for(int i = 1; i < count.length; i++) {
            if(min == count[i]) {
                result++;
            }
        }
        System.out.println(min + " " + result);
    }
}