import java.io.*;
import java.util.*;


class Main {
    
    static int[] arr;
    static int N;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);
        System.out.println(cnt);
    }
    

    private static void dfs(int stage) {
        if(stage == N){
            cnt++;
            return;
        }
        
        
        for(int i = 0; i < N; i++){
            arr[stage] = i;
            if(posible(stage)){
                dfs(stage + 1);
            }
        }
    }
    
    private static boolean posible(int col) {
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]) {
                return false;
            }else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}