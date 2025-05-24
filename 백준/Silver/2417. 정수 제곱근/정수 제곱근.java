import java.io.*;
import java.util.*;

public class Main {
    static long N, answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        binarySearch(N);
        System.out.println(answer);
    }

    static void binarySearch(long target) {
        long left = 0;
        long right = target;
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (target <= Math.pow(mid, 2)){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}