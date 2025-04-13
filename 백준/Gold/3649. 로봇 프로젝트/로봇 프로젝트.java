import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String t;
        while((t = br.readLine()) != null) {
            int target = Integer.parseInt(t) * 10_000_000;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            
            int left = 0;
            int right = N - 1;
            int max = -1;
            int l = 0;
            int r = 0;
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(sum == target) {
                    max = Math.max(max, Math.abs(arr[left] - arr[right]));
                    l = arr[left];
                    r = arr[right];
                    break;
                }
                
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            if(max == -1) sb.append("danger");
            else {
                sb.append("yes ").append(l).append(" ").append(r);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}