import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String>[] list = new ArrayList[N + 3];
        for(int i = 0; i <= N + 2; i++) {
            list[i] = new ArrayList<>();
        }
        
        list[1].add("1");
        list[2].add("1+1");
        list[2].add("2");
        list[3].add("1+1+1");
        list[3].add("1+2");
        list[3].add("2+1");
        list[3].add("3");
        
        for(int i = 4; i <= N; i++) {
            for(int j = 1; j <= 3; j++) {
                for(String str : list[i-j]) {
                    list[i].add(str+"+"+j);
                }
            }
        }
        //System.out.println(Arrays.toString(list));
        Collections.sort(list[N]);
        if(list[N].size() < M) {
            System.out.println(-1);
        }else {
            System.out.println(list[N].get(M - 1));
        }
    }
}