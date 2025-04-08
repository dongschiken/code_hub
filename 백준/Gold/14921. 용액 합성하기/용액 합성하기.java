import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = N - 1;
        int result = 0;
        while(left < right) {
            int sum = Math.abs(arr[left] + arr[right]);
            
            if(sum < min) {
                result = arr[left] + arr[right];
            }
            min = Math.min(sum, min);

            
            if(arr[left] + arr[right] >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(result);
    }
}