
import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static Queue<Node> q = new ArrayDeque<>();

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        q.offer(new Node(N-2, 0));
        q.offer(new Node(N-2, 1));
        q.offer(new Node(N-1, 0));
        q.offer(new Node(N-1, 1));
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bfs(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            setting();
        }
        int sum = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                sum += map[r][c];
            }
        }
        System.out.println(sum);
    }

    public static void bfs(int d, int p) {
        // q를 돌려서 d를 p만큼 반복
        while(!q.isEmpty()) {
            Node n = q.poll();
            int r = n.r;
            int c = n.c;
            for(int i = 0; i < p; i++) {
            // 범위를 벗어나면 0, N-1로 초기화
                r = valueCheck(r + dr[d]);
                c = valueCheck(c + dc[d]);
            }
            visited[r][c] = true;
            map[r][c] += 1;
        }
        // 대각선 4방향 확인해서 +1
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(visited[r][c]) {
                    for(int i = 1; i < dr.length; i+=2) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if(check(nr , nc)) continue;
                        if(map[nr][nc] > 0) map[r][c] += 1;
                    } 
                }
            }
        }
    }

    public static boolean check(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= N;
    }

    public static int valueCheck(int rc) {
        if(rc >= N) return 0;
        else if(rc < 0) return N - 1; 
        return rc;
    }
		// 방문안한곳중 2가 넘는곳을 q에 넣고, map에서 -2 해줌
		// 방문한곳은 false처리
    public static void setting() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(!visited[r][c] && map[r][c] >= 2) {
                    q.offer(new Node(r, c));
                    map[r][c] -= 2;
                } else if(visited[r][c]) visited[r][c] = false;
            }
        }
    }
}
