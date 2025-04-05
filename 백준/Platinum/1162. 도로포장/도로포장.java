import java.util.*;
import java.io.*;

class Main {
    
    static List<List<Node>> graph;
    static long[][] dist;
    static int N, M, K;
    static class Node implements Comparable<Node> {
        // 도로 포장 개수 lc
        // 거리 w
        // 정점 v
        int v, lc;
        long w;
        public Node(int v, long w, int lc) {
            this.v = v;
            this.w = w;
            this.lc = lc;
        }
        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.w, other.w);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new long[N+1][K+1];
        graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }
        
        djikstra();
        long min = Long.MAX_VALUE;
        for(int i = 0; i <= K; i++) {
            if(dist[N][i] != Long.MAX_VALUE)
                min = Math.min(dist[N][i], min);
        }
        System.out.println(min);
    }
    public static void djikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));
        for(long[] i : dist) {
            Arrays.fill(i, Long.MAX_VALUE);
        }
        dist[1][0] = 0;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(curr.w > dist[curr.v][curr.lc]) continue;
            for(Node next : graph.get(curr.v)) {
                // 도로 포장 하지 않을경우
                if(dist[next.v][curr.lc] > curr.w + next.w) {
                    dist[next.v][curr.lc] = curr.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v][curr.lc], curr.lc));
                }
                
                // 도로 포장 할 경우
                if(curr.lc < K && dist[next.v][curr.lc+1] > curr.w) {
                    dist[next.v][curr.lc+1] = curr.w;
                    pq.offer(new Node(next.v, curr.w, curr.lc+1));
                }
            }
        }
    }
}