import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, E;
	static int[] dist;
	static List<Node>[] list;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>(
			(o1, o2) -> o1.w - o2.w
			);
	static class Node {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		public Node() {
			super();
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 2개의 정점이 주어지니까 이 정점을 지나가면 true
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 1 2 3 4
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int t1 = Integer.parseInt(st.nextToken());
		int t2 = Integer.parseInt(st.nextToken());
		// 4번만하면된다.
		// 1 번에서 2, 3번 가는 경로가 있는지?
		// 1번에 t1
		// t1 -> t2 -> N
		
		// 1번에 t2
		// t2 -> t1 -> N;
		
		int sum1 = 0;
		int sum2 = 0;
		int[] arr1 = {1, t1, t2, N};
		int[] arr2 = {1, t2, t1, N};
		boolean check1 = true;
		boolean check2 = true;
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(arr1[i]);
			if(dist[arr1[i + 1]] == Integer.MAX_VALUE) {
				check1 = false;
				break;
			}
			sum1 += dist[arr1[i + 1]];
		}
		
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(arr2[i]);
			if(dist[arr1[i + 1]] == Integer.MAX_VALUE) {
				check2 = false;
				break;
			}
			sum2 += dist[arr2[i + 1]];
		}
		
		if(!check1 && !check2) System.out.println(-1);
		else System.out.println(Math.min(sum1, sum2));
	}

	private static void dijkstra(int i) {
		boolean[] visited = new boolean[N + 1];
		pq.offer(new Node(i, 0));
		dist[i] = 0;
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			for (Node node : list[curr.v]) {
				if(!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.offer(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
}