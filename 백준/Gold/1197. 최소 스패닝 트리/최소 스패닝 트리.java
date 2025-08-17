import java.io.*;
import java.util.*;

public class Main {
    
    static int parents[];
    public static class Edge implements Comparable<Edge> {
        int a, b, d;
        
        public Edge(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.d, other.d);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, d));
        }
        
        int cnt = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int a = edge.a;
            int b = edge.b;
            int d = edge.d;
            if(union(a, b)) {
                cnt++;
                sum += d;
                if(cnt >= M - 1) break;
            }
        }
        System.out.println(sum);
    }
    
    public static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x == y) {
            return false;
        }
        
        if(x > y) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
        
        return true;
    }
}