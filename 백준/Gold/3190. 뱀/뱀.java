import java.io.*;
import java.util.*;

public class Main {
    
    public static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return this.r + " " + this.c;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 상 하 좌 우 순서
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        boolean[][] apples = new boolean[N][N];
        boolean[][] snakes = new boolean[N][N];
        String[] nDirection = new String[10001];
        Deque<Node> d = new ArrayDeque<>();
        int[][] map = new int[N][N];
        // 오른쪽으로 시작
        int direction = 3;
        int time = 0;
        // 사과 개수
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            apples[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }
        // 방향전환
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            nDirection[Integer.parseInt(st.nextToken())] = st.nextToken();
        }
        d.offer(new Node(0, 0));
        snakes[0][0] = true;
        while(true) {
            time++;
            
            //머리이동
            Node curr = d.peekFirst();
            int r = curr.r;
            int c = curr.c;
            int nr = r + dr[direction];
            int nc = c + dc[direction];
            d.offerFirst(new Node(nr, nc));
            
            //머리 위치에 몸통, 벽(N) 확인
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                break;
            }
            
            //-> 뱀위치[현재 r][현재 c] = true 있으면 break
            //-> 뱀위치[현재 r][현재 c] = false 없으면 pass 
            if(snakes[nr][nc]) {
                break;
            }
            snakes[nr][nc] = true;
            
            //사과 확인
            //사과[현재 r][현재 c] = true 사과 먹음 r c = false 꼬리 flag = true
            //사과[현재 r][현재 c] = false 꼬리 플래스 false(아무것도 안해도 됌)
            boolean appleFlag = false;
            if(apples[nr][nc]) {
                appleFlag = true;
                apples[nr][nc] = false;
            }
            
            //flag = true 사과 있으면 꼬리 제거 X
            //flag = flase 사과 없으면 꼬리 제거 O
            if(!appleFlag) {
                Node delete = d.pollLast();
                snakes[delete.r][delete.c] = false;
            }
            
            //방향전환 확인
            String next = nDirection[time];
            
            //방향전환
            if(next != null) {
                direction = changeDirection(next, direction);
            }
        }
        System.out.println(time);
    }
    
    public static int changeDirection(String next, int prev) {
        if(next.equals("L")) {
            switch(prev) {
                case 0: return 2;
                case 1: return 3;
                case 2: return 1;
                case 3: return 0;
                default: return 0;
            }
        } else {
            switch(prev) {
                case 0: return 3;
                case 1: return 2;
                case 2: return 0;
                case 3: return 1;
                default: return 0;
            }
        }
    }
}