import java.io.*;
import java.util.*;

public class Main {
    
    static Map<String, Boolean> map;
    static int N, M;
    static class Node {
        int x, y, w;
        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x+" "+y, true);
        }
        int result = bfs();
        System.out.println(result);
    }
    
    public static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));
        while(!q.isEmpty()) {
            Node n = q.poll();
            if(n.y == M) {
                return n.w;
            }
            for(int i = n.x - 2; i <= n.x + 2; i++) {
                for(int j = n.y - 2; j <= n.y + 2; j++) {
                    if(map.get(i+" "+j) != null && map.get(i+" "+j) == true) {
                        q.offer(new Node(i, j, n.w + 1));
                        map.put(i+" "+j, false);
                    }
                }
            }
        }
        return -1;
    }
}