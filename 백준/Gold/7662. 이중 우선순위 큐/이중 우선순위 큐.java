import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                if(s[0].equals("I")) {
                    map.merge(Integer.parseInt(s[1]), 1, Integer::sum);
                } else {
                    if(s[1].equals("1")) {
                        if(map.isEmpty()) continue;
                        int max = map.lastKey();
                        if(map.get(max) == 1) {
                            map.remove(max);
                        } else {
                            map.merge(max, -1, Integer::sum);
                        }
                    } else if(s[1].equals("-1")) {
                        if(map.isEmpty()) continue;
                        int min = map.firstKey();
                        if(map.get(min) == 1) {
                            map.remove(min);
                        } else {
                            map.merge(min, -1, Integer::sum);
                        }
                    }
                }
            }
            if(map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int max = map.lastKey();
                int min = map.firstKey();
                sb.append(max).append(" ").append(min).append("\n");
            }
            map.clear();
        }
        System.out.println(sb);
    }
}