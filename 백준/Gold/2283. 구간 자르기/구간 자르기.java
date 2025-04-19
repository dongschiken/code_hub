import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // max 위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int max = -1;
        int min = Integer.MAX_VALUE;
        int[] count = new int[1_000_001];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j = a; j < b; j++) {
                count[j]++;
            }
            min = Math.min(a, min);
            max = Math.max(b, max);
        }
        int[] sum = new int[max + 1];
        
        
        sum[min] = count[min];
        for(int i = min + 1; i < max; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        
        for(int i = max; i > 0; i--) {
        	sum[i] = sum[i - 1];
        }
        sum[0] = 0;
        int l = 0;
        int r = 0;
        int[] result = new int[2];
        boolean find = false;
        while(r <= max) {
            int minus = sum[r] - sum[l];
            if(l == r) {
                r++;
                continue;
            }
            if(minus == target) {
                result[0] = l;
                result[1] = r;
                find = true;
                break;
            }
            
            if(minus <= target) {
                r++;
            }else {
                l++;
            }
        }
        if(!find) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}

