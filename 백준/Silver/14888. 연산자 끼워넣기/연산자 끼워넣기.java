import java.io.*;
import java.util.*;

public class Main {
    
    static int[] oCount = new int[4];
    static char[] operators = new char[4];
    static List<String> list = new ArrayList<>();
    static int N;
    static int M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = N - 1;
        operators[0] = '+';
        operators[1] = '-';
        operators[2] = '*';
        operators[3] = '/';
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            oCount[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, "");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < list.size(); i++) {
            int temp = nums[0];
            for(int j = 0; j < M; j++) {
                // 0 1 1 2 2 3
                switch(list.get(i).charAt(j)) {
                    case '+':
                        temp = temp + nums[j+1];
                        break;
                    case '-':
                        temp = temp - nums[j+1];
                        break;
                    case '*':
                        temp = temp * nums[j+1];
                        break;
                    case '/':
                        temp = temp / nums[j+1];
                        break;
                }
            }
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int stage, String str) {
        if(stage == M) {
            list.add(str);
            return;
        }
        if(stage > N) return;
        
        for(int i = 0; i < 4; i++) {
            if(oCount[i] > 0) {
                oCount[i]--;
                dfs(stage + 1, str + operators[i]);
                oCount[i]++;
            }
        }
    }
    
}