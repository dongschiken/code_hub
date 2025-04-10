import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sums = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + i;
       }
        int left = 0;
        int right = 1;
        int count = 0;
        while(left < N && right <= N) {
            int sum = sums[right] - sums[left];
            if(sum == N) count++; 
            if(sum <= N) {
                right++;
            }else {
                left++;
            }
        }
        System.out.println(count);
    }
}