import java.io.*;
import java.util.*;

public class Main {
    
    static int[] oCount = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            oCount[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int stage, int value) {
        if(stage == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        if(stage > N) return;
        
        for(int i = 0; i < 4; i++) {
            if(oCount[i] > 0) {
                oCount[i]--;
                switch(i) {
                    case 0:
                        dfs(stage + 1, value + nums[stage]);
                        break;
                    case 1:
                        dfs(stage + 1, value - nums[stage]);
                        break;
                    case 2:
                        dfs(stage + 1, value * nums[stage]);
                        break;
                    case 3:
                        dfs(stage + 1, value / nums[stage]);
                        break;
                }
                oCount[i]++;
            }
        }
    }
    
}