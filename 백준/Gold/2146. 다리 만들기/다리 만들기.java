import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static List<Edge>[] edges; 
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}	
	}
	
	// MST를 만들기 위해서는 크루스칼 알고리즘이 필요하다.
	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//모든 지점 숫자를 바꾸고 내 지점을 제외한 다른 지점에 연결
		N  = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c] && map[r][c] == 1) {
					dfs(r, c, ++cnt);
				}
			}
		}
		
		cnt = 0;
		int min = 100_000_000;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 0, 자기자신과 똑같은 노드는 제외
				int curr = map[r][c];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(curr != 0 && map[i][j] != curr && map[i][j] != 0) {
//							System.out.println("curr : "+curr);
//							System.out.println("r1 : "+r +", "+ "r2 : "+i );
//							System.out.println("c1 : "+c +", "+ "c2 : "+j );
//							System.out.println(Math.abs(r - i) + Math.abs(c - j));
							// 그 위치의 길이, 노드1, 노드2를 edge에 넣는다.
							// | r1 - r2 | + | c1 - c2 | - 1
							min = Math.min(min, Math.abs(r - i) + Math.abs(c - j));
						}
					}
				}
			}
		}
		System.out.println(min - 1);
		
	}


	private static void dfs(int r, int c, int cnt) {
		Queue<Node> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new Node(r, c));
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			r = n.r;
			c = n.c;
			map[r][c] = cnt;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr, nc)) continue;
				if(!visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new Node(nr, nc));
				} 
			}
		}
	}


	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}
}
