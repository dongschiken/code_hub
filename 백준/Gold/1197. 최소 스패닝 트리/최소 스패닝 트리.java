import java.util.*;
import java.io.*;

public class Main {
    
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        int from, to, d;
        public Edge(int from, int to, int d) {
            this.from = from;
            this.to = to;
            this.d = d;
        }
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.d, other.d);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        List<Edge> edges = new ArrayList<>();
        for(int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, d));
        }
        
        Collections.sort(edges);
        
        int sum = 0;
        int cnt = 0;
        for(Edge edge : edges) {
            if(!union(edge.from, edge.to)) {
                sum += edge.d;
                cnt++;
                if(cnt == M - 1) break;
            }
        }
        System.out.println(sum);
    }
    
    public static boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }
    public static boolean union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        
        if(pX == pY) return true;
        
        if(pX > pY) {
            parent[pX] = pY;
        } else {
            parent[pY] = pX;
        }
        return false;
    }
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}