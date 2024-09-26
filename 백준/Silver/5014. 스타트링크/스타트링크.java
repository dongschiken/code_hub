import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	static boolean[] visited;
	// F : 층수, S : 시작지점, G : 끝지점, U : 위로몇칸, D : 아래로몇칸
	static Queue<Node> q = new ArrayDeque<>();	
	static int F, S, G, U, D;
	static class Node {
		int v, cnt;

		public Node(int v, int cnt) {
			super();
			this.v = v;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", cnt=" + cnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visited = new boolean[F + 1];
		int result = bfs();
		if(result == -1) System.out.println("use the stairs");
		else System.out.println(result);
	}

	private static int bfs() {
		q.offer(new Node(S, 0));
		while (!q.isEmpty()) {
			Node curr = q.poll();
			int c = curr.v;
			int cnt = curr.cnt;
			// 중복해서 q에 같은 지점을 넣는것을 방지 ( 메모리 초과 )
			
			
			if(c == G) {
				return cnt;
			}
			int u = c + U;
			int d = c - D;
			
			if(u <= F && !visited[u]) {
				q.offer(new Node(u, cnt + 1));
				visited[u] = true;
			}
			if(d > 0 && !visited[d]) {
				q.offer(new Node(d, cnt + 1));
				visited[d] = true;
			}
		}
		return -1;
	}
}
