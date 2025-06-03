import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
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
            if(S.equals(T)) {
                answer = 1;
            }
            return;
        }
        
        if(T.endsWith("A")) {
            dfs(new String(T.substring(0, tl - 1)), S);
        }
        if(T.startsWith("B")) {
            dfs(new StringBuilder(T.substring(1)).reverse().toString(), S);
        }
    }
}