import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                map.compute(st.nextToken(),
                           (K, V) -> V == null ? 1 : ++V
                           );
            }
            int count = 1;
            for(Integer i : map.values()) {
                count *= i + 1;
            }
            count -= 1;
            sb.append(count).append("\n");
            map.clear();
        }
        System.out.println(sb);
    }
}