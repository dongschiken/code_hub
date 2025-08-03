import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] map;
    static int max = -1;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                int m = 0;
                switch(ch) {
                    case 'C':
                        m = 1;
                        break;
                    case 'P':
                        m = 2;
                        break;
                    case 'Z':
                        m = 3;
                        break;
                    case 'Y':
                        m = 4;
                        break;
                }
                map[i][j] = m;
            }
        }
        
        // 오른쪽 바꿔서 확인
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N - 1; c++) {
                switchCandy(r, c, r, c + 1);
                // 전체 확인
                searchMax();
                switchCandy(r, c, r, c + 1);
            }
        }
        
        // 아래쪽 바꿔서 확인
        for(int c = 0; c < N; c++) {
            for(int r = 0; r < N - 1; r++) {
                switchCandy(r, c, r + 1, c);
                // 전체 확인
                searchMax();
                switchCandy(r, c, r + 1, c);
            }
        }
        System.out.println(max);
    }
    
    public static void switchCandy(int or1, int oc1, int or2, int oc2) {
        int tmp = map[or1][oc1];
        map[or1][oc1] = map[or2][oc2];
        map[or2][oc2] = tmp;
    }
    
    public static void searchMax() {
        // 오른쪽으로 먼저 확인
        // 이전 사탕 == 현재 사탕 count++ 
        // 이전 사탕 != 현재 사탕 count = 0;
        // 이전 사탕 <= 현재 사탕
        for(int r = 0; r < N; r++) {
            int count = 1;
            int prev = map[r][0];
            int curr = 0;
            for(int c = 1; c < N; c++) {
                curr = map[r][c];
                if(prev == curr) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
                prev = curr;
            }
        }
        
        // 아래쪽으로 확인
        for(int c = 0; c < N; c++) {
            int count = 1;
            int prev = map[0][c];
            int curr = 0;
            for(int r = 1; r < N; r++) {
                curr = map[r][c];
                if(prev == curr) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
                prev = curr;
            }
        }
    }
}