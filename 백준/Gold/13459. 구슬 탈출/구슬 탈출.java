import java.io.*;
import java.util.*;

public class Main {
    
                    // 상  우 하  좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    // 방문체크
    static boolean[][][][] visited;
    // 맵
    static char[][] map;
    static int min;
    static int N, M;
    static Queue<Node> q = new ArrayDeque<>();
    static class Node {
        int redR, redC, blueR, blueC, cnt;
        
        public Node(int redR, int redC, int blueR, int blueC, int cnt) {
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
            this.cnt =cnt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] s = new int[4];
        visited = new boolean[N][M][N][M];
        map = new char[N][M];
        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
                if(map[r][c] == 'R') {
                    s[0] = r;
                    s[1] = c;
                }else if(map[r][c] == 'B') {
                    s[2] = r;
                    s[3] = c;
                }
            }
        }
        q.offer(new Node(s[0], s[1], s[2], s[3], 0));
        visited[s[0]][s[1]][s[2]][s[3]] = true;
        int result = simul() ? 1 : 0;
        System.out.println(result);
    }
    
    public static boolean simul() {
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr.cnt >= 10) {
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                boolean blueHole = false;
                boolean redHole = false;
                // 레드
                int nRedR = curr.redR;
                int nRedC = curr.redC;
                int nBlueR = curr.blueR;
                int nBlueC = curr.blueC;
                while(map[nRedR + dr[i]][nRedC + dc[i]] != '#') {
                    nRedR += dr[i];
                    nRedC += dc[i];
                    if(map[nRedR][nRedC] == 'O') {
                        redHole = true;
                        break;
                    }
                }
                
                // 블루
                while(map[nBlueR + dr[i]][nBlueC + dc[i]] != '#') {
                    nBlueR += dr[i];
                    nBlueC += dc[i];
                    if(map[nBlueR][nBlueC] == 'O') {
                        blueHole = true;
                        break;
                    }
                }
                
                // 파란구슬 구멍 들어감
                if(blueHole) {
                    continue;
                }
                
                // 빨간구슬 구멍 들어감
                if(redHole) {
                    return true;
                }
                
                // 동일한 위치에 도착했을 때
                if(nRedR == nBlueR && nRedC == nBlueC) {
                    switch(i) {
                        case 0:
                            // 상 일때는 누가 더 큰 r값을 가졌었냐
                            if(curr.redR > curr.blueR) {
                                nRedR -= dr[i];
                            }else {
                                nBlueR -= dr[i];
                            }
                            break;
                        case 1:
                            if(curr.redC < curr.blueC) {
                                nRedC -= dc[i];
                            }else {
                                nBlueC -= dc[i];
                            }
                            break;
                        case 2:
                            if(curr.redR < curr.blueR) {
                                nRedR -= dr[i];
                            }else {
                                nBlueR -= dr[i];
                            }
                            break;
                        case 3:
                            if(curr.redC > curr.blueC) {
                                nRedC -= dc[i];
                            }else {
                                nBlueC -= dc[i];
                            }
                            break;
                    }
                }
                if(!visited[nRedR][nRedC][nBlueR][nBlueC]) {
                    visited[nRedR][nRedC][nBlueR][nBlueC] = true;
                    q.offer(new Node(nRedR, nRedC, nBlueR, nBlueC, curr.cnt + 1));
                }
            }
        }
        return false;
    }
}