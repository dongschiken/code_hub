import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            int tmp = 0;
            for(int i = 19; i > 0; i--) {
                for(int j = 0; j < i; j++) {
                    if(arr[j] > arr[j + 1]) {
                        count++;
                        tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
            sb.append(t+1).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}