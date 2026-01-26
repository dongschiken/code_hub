import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static boolean[] arr;
    static int[][] map;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = N / 2;
        arr = new boolean[N];
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }
    
    public static void dfs(int s, int t) {
        if(M == t) {
            int sum1 = 0;
            int sum2 = 0;
 
            for(int i = 0; i < N; i++) {
                if(arr[i]) {
                    list1.add(i);
                } else {
                    list2.add(i);
                }
            }
            
            for(int i = 0; i < M - 1; i++) {
                for(int j = i + 1; j < M; j++) {
                    sum1 += map[list1.get(i)][list1.get(j)] + map[list1.get(j)][list1.get(i)];
                    sum2 += map[list2.get(i)][list2.get(j)] + map[list2.get(j)][list2.get(i)];
                }
            }     
            
            min = Math.min(Math.abs(sum1 - sum2), min);
            
            list1.clear();
            list2.clear();
            return;
        }
        
        if(M < t) {
            return;
        }
        
        for(int i = s; i < N; i++) {
            if(!arr[i]) {
                arr[i] = true;
                dfs(i + 1, t + 1);
                arr[i] = false;
            }
        }
    }
}