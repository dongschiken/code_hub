import java.util.*;
import java.io.*;

class Solution {
    
    public static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static char[][] map;
    static int[] dr = {1, 1, 0};
    static int[] dc = {0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // 2 * 2격자 찾기 -> 전부다 찾고 제거
        // 앞, 밑, 대각
        map = new char[m][n];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                map[r][c] = board[r].charAt(c);
            }
        }
        
        while(true) {
            int check = remove(m, n);
            // 더이상 삭제할 블럭이 없으면 break;
            if(check == 0) break;
            answer += check;
            down(m, n);
        }
        // 내리기
        // 내리기는 해당 열의 남아있는 블럭의 모든 위치를 찾고 맨 밑에서부터 채우기
        return answer;
    }
    
    public static void down(int m, int n) {
        for(int c = 0; c < n; c++) {
            List<Character> list = new ArrayList<>();
            for(int r = m - 1; r >= 0; r--) {
                if(map[r][c] >= 'A' && map[r][c] <= 'Z') {
                    list.add(map[r][c]);
                }
            }
            int idx = m - 1;
            for(int i = 0; i < list.size(); i++) {
                map[idx--][c] = list.get(i);
            }
            while(idx >= 0) {
                map[idx--][c] = 'z';
            }
        }
    }
    
    public static int remove(int m, int n) {
        List<Node> list = new ArrayList<>();
        // 중복처리
        boolean[][] b = new boolean[m][n];
        int count = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                char o1 = map[r][c];
                if(o1 == 'z') continue;
                if(r >= m - 1 || c >= n - 1) continue;
                for(int i = 0; i < 3; i++) {
                    int nr = dr[i] + r;
                    int nc = dc[i] + c;
                    char o2 = map[nr][nc];
                    if(o1 != o2) {
                        break;
                    }
                    if(i == 2 && o1 == o2) {
                        list.add(new Node(r, c));
                        list.add(new Node(r + dr[0], c + dc[0]));
                        list.add(new Node(r + dr[1], c + dc[1]));
                        list.add(new Node(nr, nc));
                    }
                }
            }
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(!b[list.get(i).r][list.get(i).c]) {
                count++;
                b[list.get(i).r][list.get(i).c] = true;
            }
            map[list.get(i).r][list.get(i).c] = 'z';
        }
        return count;
    }
}