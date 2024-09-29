import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> q;
	static int N, cnt, result;
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Node() {
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int max = 0;
			result = -1;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[j][j2]);
				}
			}
			
			for (int j = 0; j <= max; j++) {
				cnt = 0;
				visited = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!visited[r][c] && map[r][c] > j) {
							dfs(r, c, j);
							cnt++;
						}
					}
				}
				result = Math.max(cnt, result);
			}
			bw.write("#"+i+" "+result+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int r, int c, int val) {
		q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new Node(r, c));
		while (!q.isEmpty()) {
			Node n = q.poll();
			r = n.r;
			c = n.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr, nc)) continue; 
				if(!visited[nr][nc] && map[nr][nc] > val) {
					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}
}
