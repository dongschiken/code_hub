import java.util.*;
import java.io.*;

class Main {
    
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static int[] dist;
    static int[] path;
    static int N, M;
    static class Node implements Comparable<Node> {
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        N = read();
        M = read();
        
        dist = new int[N+1];
        path = new int[N+1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            int w = read();
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));   
        }
        
        djikstra(1);
        int count = 0;
        for(int i = 2; i <= N; i++) {
            count++;
            sb.append(i).append(" ").append(path[i]);
            sb.append("\n");
        }
        System.out.println(count);
        System.out.println(sb);
    }
    public static void djikstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        Arrays.fill(dist, INF);
        dist[s] = 0;
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int node = curr.v;
            int distance = curr.w;
            
            if(dist[node] < distance) continue;
            for(Node next : graph.get(node)) {
                if(dist[next.v] > dist[curr.v] + next.w) {
                    dist[next.v] = dist[curr.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                    path[next.v] = node;
                }
            }
        }
    }
    
    static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}