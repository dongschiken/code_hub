import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
			list[b].add(new Node(a, w));
		}
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			map = new LinkedHashMap<>();
			arr[i][i] = 0;
			dist[i] = 0;
			dijkstra(dist, visited, i);
			Set<Entry<Integer, Integer>> s = map.entrySet();
			Iterator<Entry<Integer, Integer>> ir = s.iterator();
			while (ir.hasNext()) {
				Entry<Integer, Integer> entry = ir.next();
				int key = entry.getKey();
				int value = entry.getValue();
				if (value == i) {
					arr[i][key] = key;
				} else {
					int next = key;
					while (true) {
						int tmp = next;
						next = map.get(next);
						if(next == i) {
							arr[i][key] = tmp;
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(arr[i][j] == 0) bw.write("- ");
				else bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
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
