import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            for(int i = N; N > 0; ) {
                list.add(N % 2);
                N = N / 2;
            }
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == 1) {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");
            list.clear();
        }
        System.out.println(sb);
    }
}