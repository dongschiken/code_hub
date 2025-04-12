import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());        
        int M = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(a);
        StringBuilder sb = new StringBuilder();
        for(Integer in : a) {
            sb.append(in).append(" ");
        }
        System.out.println(sb);
    }
}