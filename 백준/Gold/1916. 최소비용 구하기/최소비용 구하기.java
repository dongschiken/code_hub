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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dist = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			for (Node next : list[curr.v]) {
				if(!visited[next.v] && dist[next.v] > dist[curr.v] + next.w) {
					dist[next.v] = dist[curr.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		System.out.println(dist[end]);
		
	}
}
