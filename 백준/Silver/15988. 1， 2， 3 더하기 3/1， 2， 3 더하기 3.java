import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[1_000_001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4; i < arr.length; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1_000_000_009;
        }
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(arr[a]).append("\n");
        }
        System.out.println(sb);
    }
}