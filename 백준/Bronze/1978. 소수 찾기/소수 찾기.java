import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] prime = new int[1001];
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(prime, -1);
        
        for(int i = 2; i < prime.length; i++) {
            for(int j = i + i; j < prime.length; j += i) {
                if(prime[i] == 1) {
                    break;
                }
                if(j % i == 0) {
                    prime[j] = 1;
                }
            }
        }
        
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 2) continue;
            if(prime[arr[i]] == -1) {
                result++;
            }
        }
        System.out.println(result);
    }
}