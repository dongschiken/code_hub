import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < N; j++) {
                if(temp.charAt(j) == 'R') {
                    map[i][j] = 1;
                }else if(temp.charAt(j) == 'B') {
                    map[i][j] = 2;
                }else {
                    map[i][j] = 3;
                }
            }
        }
        
        
        for(int i = 0; i < 2; i++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    if(visited[r][c]) continue;
                    bfs(r, c);
                    cnt++;
                }
            }
            bw.write(cnt+" ");
            change();
        }
        bw.flush();
    } // main
    
    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        int curr = map[r][c];
        visited[r][c] = true;
        q.offer(new int[] {r, c});
        while(!q.isEmpty()) {
            int[] rc = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = rc[0] + dr[d];
                int nc = rc[1] + dc[d];
                
                if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == curr){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                } 
            }
        }
    }
    
    public static boolean check(int r, int c){
        return r < N && r >= 0 && c < N && c >= 0;
    }
    
    public static void change() {
         for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(map[r][c] == 3) map[r][c] = 1;
            }
        }
    }
    
} // class