import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		public Edge() {
			super();
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
		
	}
	
	static int[] p; // 최상위 부모를 저장할 배열
	static int V, E; // 정점, 간선 개수
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		edges = new Edge[E];
//		edges[0] = new Edge(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		
		// 크루스칼 1장 정렬해라!
		Arrays.sort(edges, (o1, o2) -> o1.W - o2.W);
		
		// 크루스칼 2장 V-1개의 간선을 뽑아라 -> 사이클이 발생하지 않게
		p = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		int ans = 0;  // 최소비용을 저장하기 위한 변수
		int pick = 0; // 내가 뽑은 간선의 개수
		
		for (int i = 0; i < E; i++) {
			int a = edges[i].A;
			int b = edges[i].B;
			
			// 서로의 부모가 다를경우에 합치는 과정
			if(findSet(a) != findSet(b)) {
				union(a, b);
				ans += edges[i].W;
				pick++;
			}
			if(pick == V - 1) break;
		}
		
		System.out.println(ans);
		
	}
	
	static void union(int x, int y) {
		// x, y가 대표자 여야만 한다.
		p[findSet(y)] = findSet(x); // x그룹에 y그룹을 넣는것.	
	}
	
	static int findSet(int x) {
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
}
