import java.util.*;
import java.io.*;

public class Main {

    static List<Edge>[] graph;
    static final int INF = 100_000_000;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정점 수
            int M = Integer.parseInt(st.nextToken()); // 도로 수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 수
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 도로 입력 (양방향)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[v].add(new Edge(w, cost));
                graph[w].add(new Edge(v, cost));
            }

            // 웜홀 입력 (단방향, 음수 가중치)
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[v].add(new Edge(w, -cost));
            }

            // 방문 여부 배열
            boolean[] visited = new boolean[N + 1];
            boolean hasNegativeCycle = false;

            // 모든 정점 탐색
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (bellmanFord(N, i, visited)) {
                        hasNegativeCycle = true;
                        break;
                    }
                }
            }

            bw.write((hasNegativeCycle ? "YES" : "NO") + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean bellmanFord(int N, int start, boolean[] visited) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 최대 N-1번 반복
        for (int i = 1; i <= N; i++) {
            boolean updated = false;
            for (int u = 1; u <= N; u++) {
                if (dist[u] == INF) continue; // 방문할 수 없는 노드
                visited[u] = true; // 노드 방문 처리
                for (Edge e : graph[u]) {
                    if (dist[e.to] > dist[u] + e.cost) {
                        dist[e.to] = dist[u] + e.cost;
                        updated = true;

                        // N번째 반복에서 Relaxation 발생 시 음수 사이클 존재
                        if (i == N) {
                            return true;
                        }
                    }
                }
            }
            if (!updated) break; // 더 이상 갱신되지 않으면 종료
        }
        return false; // 음수 사이클 없음
    }
}
