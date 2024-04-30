import java.io.*;
import java.util.*;

public class Main{
    
    private static int[][] virus;
    private static boolean[] check;
    private static int count = 0;
    private static int com_node;
    private static int line;
    
    public static void main(String[] args) throws IOException, NumberFormatException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        com_node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        
        virus = new int[com_node+1][com_node+1];
        check = new boolean[com_node+1];
        
        StringTokenizer st;
        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            virus[start][end] = virus[end][start] = 1;
        }
        bfs(1);
        System.out.println(count-1);
    }
    public static void bfs(int start){
        check[start] = true;
        count++;
        
        for(int i = 0; i <= com_node; i++){
            if(virus[start][i] == 1 && !check[i]){
                bfs(i);
            }
        }
    }
}