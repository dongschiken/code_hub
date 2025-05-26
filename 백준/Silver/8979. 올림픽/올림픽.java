import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 3; j++) {
                list[target].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        int rank = 1;
        for(int i = 1; i <= N; i++) {
            if(i == M) continue;
            if(list[M].get(0) < list[i].get(0)) {
                rank++;
                continue;
            } else if(list[M].get(0) > list[i].get(0)) {
                continue;
            } else if(list[M].get(1) < list[i].get(1)) {
                rank++;
                continue;
            } else if(list[M].get(1) > list[i].get(1)) {
                continue;
            } else if(list[M].get(2) < list[i].get(2)) {
                rank++;
                continue;
            }
        }
        System.out.println(rank);
    }
}