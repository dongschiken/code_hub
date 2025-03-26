import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    static class Node implements Comparable<Node> {
        int id, cost, edges;
        public Node(int id, int cost, int edges) {
            this.id = id;
            this.cost = cost;
            this.edges = edges;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }
        
        // 최소 도로 수별 비용을 저장할 배열
        // dp[i][j] = i번 도시에 j개의 도로를 사용하여 도달하는 최소 비용
        int[][] dp = new int[N+1][N];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[S][0] = 0;  // 시작점은 0개 도로, 0 비용
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0, 0));
        
        // 각 도로 수별 최소 비용 저장 (출발지->목적지)
        int[] minCostByEdges = new int[N];
        Arrays.fill(minCostByEdges, Integer.MAX_VALUE);
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            // 이미 더 좋은 경로를 찾았다면 스킵
            if (curr.cost > dp[curr.id][curr.edges]) continue;
            
            // 목적지에 도달했다면 도로 수별 최소 비용 업데이트
            if (curr.id == D) {
                minCostByEdges[curr.edges] = Math.min(minCostByEdges[curr.edges], curr.cost);
                continue;  // 목적지에서 더 탐색할 필요 없음
            }
            
            for (Edge next : graph[curr.id]) {
                int newEdges = curr.edges + 1;
                
                // 도로 수 제한 (최대 N-1개)
                if (newEdges >= N) continue;
                
                int newCost = curr.cost + next.cost;
                
                // 더 나은 경로를 찾았다면 업데이트
                if (newCost < dp[next.to][newEdges]) {
                    dp[next.to][newEdges] = newCost;
                    pq.offer(new Node(next.to, newCost, newEdges));
                }
            }
        }
        
        // 초기 최소 비용 출력
        int initialMinCost = Integer.MAX_VALUE;
        for (int e = 0; e < N; e++) {
            if (minCostByEdges[e] != Integer.MAX_VALUE) {
                initialMinCost = Math.min(initialMinCost, minCostByEdges[e]);
            }
        }
        System.out.println(initialMinCost);
        
        // 세금 인상에 따른 최소 비용 계산
        int totalTax = 0;
        for (int i = 0; i < K; i++) {
            totalTax += Integer.parseInt(br.readLine());
            
            int minCost = Integer.MAX_VALUE;
            for (int e = 0; e < N; e++) {
                if (minCostByEdges[e] != Integer.MAX_VALUE) {
                    int costWithTax = minCostByEdges[e] + (e * totalTax);
                    minCost = Math.min(minCost, costWithTax);
                }
            }
            System.out.println(minCost);
        }
    }
}