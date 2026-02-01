import java.io.*;
import java.util.*;

public class Main {
    
    static int answer = -1;
    public static class Node {
        int index, cnt;
        public Node(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 촌수 계산 시작 점
        int s = Integer.parseInt(st.nextToken());
        // 촌수 계산 끝 점
        int e = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        //System.out.println(Arrays.toString(list));
        bfs(N, list, s, e);
        System.out.println(answer);
    }
    
    public static void bfs(int N, List[] list, int s, int e) {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(s, 0));
        while(!q.isEmpty()) {
            Node n = q.poll();
            int curr = n.index;
            int cnt = n.cnt;
            
            if(curr == e) {
                answer = cnt;
                return;
            }
            
            if(!visited[curr]) {
                visited[curr] = true;
                for(int i = 0; i < list[curr].size(); i++) {
                    int next = (int)list[curr].get(i);
                    q.offer(new Node(next, cnt + 1));
                }
            }
        }
    }
}