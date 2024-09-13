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

	static int N, M, X;
	static List<Node>[] list;
	static int[] dist;
	static List<Integer> to; 	// 2로 갈때
	static List<Integer> from;  // 2에서 올때
	static PriorityQueue<Node> pq = new PriorityQueue<Node>(
			(o1, o2) -> o1.W - o2.W);
	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}

		public Node() {
			super();
		}

		@Override
		public String toString() {
			return "Node [V=" + V + ", W=" + W + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 학생수 N, 도로 M, 시작점이 X
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		to = new ArrayList<>();
		from = new ArrayList<>();
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
		}
		
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(i);			
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < to.size(); i++) {
			result = Math.max(result, to.get(i) + from.get(i));
		}
		System.out.println(result);
	}

	private static void dijkstra(int num) {
		boolean[] visited = new boolean[N+1];
		pq.offer(new Node(num, 0));
		dist[num] = 0;
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.V]) continue;			
			visited[curr.V] = true;
			for (Node node : list[curr.V]) {
				if(!visited[node.V] && dist[node.V] > dist[curr.V] + node.W) {
					dist[node.V] = dist[curr.V] + node.W;
					pq.offer(new Node(node.V, dist[node.V]));
				}
			}
		}
		
		if(num == X) {
			for (int i = 1; i < dist.length; i++) {
				if(i != X)
				from.add(dist[i]);
			}
		}else {
			to.add(dist[X]);
		}
	}
}
