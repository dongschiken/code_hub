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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		int[] dist = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		pq.offer(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.b]) continue;
			visited[curr.b] = true;
			for (Node next : list[curr.b]) {
				if(!visited[next.b] && dist[next.b] > dist[curr.b] + next.w) {
					dist[next.b] = dist[curr.b] + next.w;
					pq.offer(new Node(next.b, dist[next.b]));
				}
			}
		}
		
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
			else bw.write(dist[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
