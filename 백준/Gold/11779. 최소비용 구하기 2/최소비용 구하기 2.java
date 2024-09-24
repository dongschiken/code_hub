import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Map<Integer, Integer> map;
	static List<Node>[] list;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);

	static class Node {
		int b, w;

		public Node(int b, int w) {
			super();
			this.b = b;
			this.w = w;
		}

		public Node() {
			super();
		}

		@Override
		public String toString() {
			return "Node [b=" + b + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Arrays.fill(dist, Integer.MAX_VALUE);
		map = new LinkedHashMap<>();
		dist[start] = 0;
		dijkstra(dist, visited, start);
		int next = end;
		int cnt = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while (true) {
			next = map.get(next);
			stack.push(next);
			cnt++;
			if(next == start) break;
		}
		
		bw.write(dist[end]+"\n");
		bw.write(cnt+"\n");
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			bw.write(stack.pop()+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dijkstra(int[] dist, boolean[] visited, int idx) {
		pq.offer(new Node(idx, 0));
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (visited[n.b])
				continue;
			visited[n.b] = true;
			for (Node node : list[n.b]) {
				if (!visited[node.b] && dist[node.b] > dist[n.b] + node.w) {
					dist[node.b] = dist[n.b] + node.w;
					pq.offer(new Node(node.b, dist[node.b]));
					map.put(node.b, n.b);
					
				}
			}
		}
		pq.clear();
	}
}
