import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
        List<Integer>[] list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        
        boolean[] visited = new boolean[M + 1];
        int[] ramps = new int[M + 1];
        for(int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j = 1; j < strs.length; j++) {
                list[i].add(Integer.parseInt(strs[j]));
                ramps[Integer.parseInt(strs[j])]++;
                visited[Integer.parseInt(strs[j])] = true;
            }
        }
        int vCnt = 0;
        for(int i = 0; i < M + 1; i++) {
            if(visited[i]) {
                vCnt++;
            }
        }
        
        int result = 0;
        for(int i = 0; i < N; i++) {
            // 2000
            for(int j = 0; j < list[i].size(); j++) {
                ramps[list[i].get(j)]--;
            }
            // 2000
            int rCnt = 0;
            for(int j = 0; j < M + 1; j++) {
                if(visited[j]) {
                    if(ramps[j] >= 1) {
                        rCnt++;
                    }
                }
            }
            if(rCnt == vCnt) {
                result = 1;
            }
            // 2000
            for(int j = 0; j < list[i].size(); j++) {
                ramps[list[i].get(j)]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb);
    }
}