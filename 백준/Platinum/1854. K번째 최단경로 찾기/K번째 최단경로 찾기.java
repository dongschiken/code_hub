import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리
        int N = readInt();
        int M = readInt();
        int K = readInt();
        
        // 그래프 초기화
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();
            graph[a].add(new Node(b, c));
        }
        
        // 다익스트라 알고리즘 수행
        int[] result = optimizedDijkstra(N, K, graph);
        
        // 결과 출력 (빠른 출력)
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);
    }
    
    static int[] optimizedDijkstra(int N, int K, ArrayList<Node>[] graph) {
        // 각 정점별 K개의 최단 경로를 저장하는 최대 힙
        PriorityQueue<Integer>[] distances = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            distances[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        
        // 결과 배열
        int[] result = new int[N + 1];
        Arrays.fill(result, -1);
        
        // 다익스트라 알고리즘을 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0)); // 시작점
        distances[1].offer(0);
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.vertex;
            int dist = current.weight;
            
            // 현재 거리가 이미 K번째보다 크면 스킵
            if (distances[node].size() == K && dist > distances[node].peek()) {
                continue;
            }
            
            // 인접 정점 탐색
            for (Node next : graph[node]) {
                int nextNode = next.vertex;
                int nextDist = dist + next.weight;
                
                // K개 미만이면 추가
                if (distances[nextNode].size() < K) {
                    distances[nextNode].offer(nextDist);
                    pq.offer(new Node(nextNode, nextDist));
                } 
                // K개가 이미 있지만 현재 경로가 더 짧으면 갱신
                else if (nextDist < distances[nextNode].peek()) {
                    distances[nextNode].poll(); // 가장 큰 값 제거
                    distances[nextNode].offer(nextDist);
                    pq.offer(new Node(nextNode, nextDist));
                }
            }
        }
        
        // 결과 계산
        for (int i = 1; i <= N; i++) {
            if (distances[i].size() == K) {
                result[i] = distances[i].peek(); // K번째 최단경로
            }
        }
        
        return result;
    }
    
    // 빠른 정수 입력 처리
    static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}