import java.util.*;
import java.io.*;

public class Main {
    
    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 내위치를 확인해 -> 청소 안되어있다면 청소해
        // 4방향 확인해 -> 전부 청소되어있으면 후진
        // 4방향 확인해 -> 청소안되어있는 지점이 있다면 반시계 90도 회전
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 바라보는 현재 방향
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        solution(r, c, d);
        int count = 0;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(map[i][j] == 2) count++;
        	}
        }
        System.out.println(count);
    }
    
    public static void solution(int r, int c, int d) {
        while(true) {
            
            // 다음 위치를 확인했더니 없어 -> 후진했더니 1을 만났어 그럼 작동종료
            currentLocation(r, c);
            if(checkNextDirection(r, c)) {
                // 총 4번을 진행 내 위치를 기준으로 90도 4번
                for(int i = 0; i < 4; i++) {
                	d = (d + 3) % 4; // 반시계 90도 회전
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        break;
                    }
                }
            }else {
            	int nd = (d + 2) % 4;
                r += dr[nd];
                c += dc[nd];
                if(map[r][c] == 1) return;
            }
        }
    }
    
    // 다음 위치 확인
    public static boolean checkNextDirection(int r, int c) {
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(map[nr][nc] == 0) return true;
        }
        return false;
    }
    
    public static void currentLocation(int r, int c) { 
        map[r][c] = 2; // 현재위치를 청소상태로 바꿈
    }
}