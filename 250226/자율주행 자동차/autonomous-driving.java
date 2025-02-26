import java.util.*;
import java.io.*;
public class Main {
    
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0 , 1, 0, -1};
    static int N, M;
    static Queue<Node> q = new ArrayDeque<>();

    static class Node {
        int r, c, d;
        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0   1   2   3
        // 위, 오, 아, 왼
        // 후진
        // 위 -> 아 0 -> 2
        // 왼 -> 오 3 -> 1
        // 아 -> 위 2 -> 0
        // 오 -> 왼 1 -> 3
        // 이동 
        // 위 -> 왼 0 -> 3
        // 왼 -> 아 3 -> 2
        // 아 -> 오 2 -> 1
        // 오 -> 위 1 -> 0
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());
        q.offer(new Node(startR, startC, startD));
        visited[startR][startC] = true;
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) sum++;
            }
        }
        // System.out.println(Arrays.deepToString(visited));
        System.out.println(sum);
    }

    public static void bfs() {
        OUT:
        while(!q.isEmpty()) {
            Node curr = q.poll();
            // int nd = curr.d;
            // System.out.println("사방탐색" + curr.r + ", " + curr.c + ", " + curr.d);
            for(int i = 3; i >= 0; i--) {
                int nd = valueCheck(curr.d + i);
                int nr = curr.r + dr[nd];
                int nc = curr.c + dc[nd];
                if(!visited[nr][nc] && map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, nd));
                    continue OUT;
                }
            }
            if(!back(curr.r, curr.c, curr.d)) return;
        }
    }
    
    public static boolean back(int r, int c, int d) {
        // System.out.println(r + ", " + c + ", " + d);
        int md = (d + 2) % 4;
        int nr = r + dr[md];
        int nc = c + dc[md];
        if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) return false;
        // System.out.println("들어오나??");
        q.offer(new Node(nr, nc, d));
        return true;
    }

    public static int valueCheck(int v) {
        // 위 -> 왼 0 -> 3
        // 왼 -> 아 3 -> 2
        // 아 -> 오 2 -> 1
        // 오 -> 위 1 -> 0
        // 0 1 2 3
        // 1 2 3 4
        // 2 3 4 5
        // 3 4 5 6
        // 3 0 1 2
        if(v > 3) {
            v = v - 4;
        }
        return v;
    }
}