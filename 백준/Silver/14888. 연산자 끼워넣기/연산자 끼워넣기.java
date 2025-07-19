import java.io.*;
import java.util.*;

public class Main {
    
    static int[] oCount = new int[4];
    static char[] operators = new char[4];
    static List<String> list = new ArrayList<>();
    static int N;
    static int M;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = N - 1;
        nums = new int[N];
        //operators[0] = '+';
        //operators[1] = '-';
        //operators[2] = '*';
        //operators[3] = '/';
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            oCount[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int stage, int value) {
        if(stage == M) {
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
                        dfs(stage + 1, value + nums[stage + 1]);
                        break;
                    case 1:
                        dfs(stage + 1, value - nums[stage + 1]);
                        break;
                    case 2:
                        dfs(stage + 1, value * nums[stage + 1]);
                        break;
                    case 3:
                        dfs(stage + 1, value / nums[stage + 1]);
                        break;
                }
                oCount[i]++;
            }
        }
    }
    
}