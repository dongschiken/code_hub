import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int totalSum = 0;
        for(int i = 0; i < N; i++) {
            totalSum += arr[i];
        }
        
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int lr = 0;
        while(left < N) {
            int lLength = totalSum - lr;
            
            int min = Math.min(lr, lLength);
            
            // 시계 반시계의 최소값과 현재까지의 최대값을 비교
            max = Math.max(max, min);
            
            // 시계 방향이 더 클 때
            if(lr > lLength) {
                lr -= arr[left % N];
                left++;
            // 반 시계 방향이 더 클 때
            } else {
                lr += arr[right % N];
                right++;
            }
        }
        System.out.println(max);
    }
}