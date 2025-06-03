import java.io.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        
        dfs(T, S);
        System.out.println(answer);
    }
    
    public static void dfs(String T, String S) {
        int tl = T.length();
        
        if(tl == S.length()) {
            if(T.equals(S)) {
                answer = 1;
            }
            return;
        }
        
        if(T.endsWith("A")) {
            dfs(T.substring(0, tl - 1), S);
        } else if(T.endsWith("B")) {
            dfs(new StringBuilder(T.substring(0, tl - 1)).reverse().toString(), S);
        }
        
    }
}