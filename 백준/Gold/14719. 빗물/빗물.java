import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int result;
    static int[][] resultMap;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        resultMap = new int[N][M];
        st = new StringTokenizer(br.readLine());
        // 0 = 물이 안채워짐, 1 = 물이 채워짐, 2 = 블럭, 3 = 물이 채워질 수 없음
        for(int i = 0; i < M; i++) {
            int bCnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < bCnt; j++) {
                map[N - j - 1][i] = 2;
            }
        }

        for(int c = 0; c < M; c++) {
            for(int r = 0; r < N; r++) {
                lrSearch(map, r, c);
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(resultMap[i][j] == 1) result++;
            }
        }
        System.out.println(result);
    }
    
    // 좌우 탐색 알고리즘
    public static void lrSearch(int[][] map, int r, int c) {
        // r, c가 1, 2, 3이면 return
        if(map[r][c] == 2 || map[r][c] == 3 || map[r][c] == 1) return;
        boolean check1 = false;
        boolean check2 = false;
        // 왼쪽
        for(int i = c - 1; i >= 0; i--) {
            if(map[r][i] == 2) {
                check1 = true;
                break;
            }
        }
        // 오른쪽
        for(int i = c; i < M; i++) {
            if(map[r][i] == 2) {
                check2 = true;
                break;
            }
        }
        if(check1 == true && check2 == true) {
            for(int i = c - 1; i >= 0; i--) {
                if(map[r][i] == 2) {
                break;
                }
                resultMap[r][i] = 1;
            }
            // 오른쪽
            for(int i = c; i < M; i++) {
                if(map[r][i] == 2) {
                    break;
                }
                resultMap[r][i] = 1;
            }
        }else {
            for(int i = c - 1; i >= 0; i--) {
                if(map[r][i] == 2) {
                break;
                }
                map[r][i] = 3;
            }
            // 오른쪽
            for(int i = c; i < M; i++) {
                if(map[r][i] == 2) {
                    break;
                }
                map[r][i] = 3;
            }
        }
    } 
}