import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<Node> q;
	static boolean[][] visited;
	static int N, M;
	static class Node {
		int r, c, w;
		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", w=" + w + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			q = new ArrayDeque<>();
			for (int j = 0; j < N; j++) {
				char[] ch = br.readLine().toCharArray();
				for (int j2 = 0; j2 < M; j2++) {
					if (ch[j2] == 'W') {
						visited[j][j2] = true;
						q.offer(new Node(j, j2, 0));
					}
				}
			} // map
			bfs();
			int sum = 0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					sum += map[j][j2];
				}
			}
			bw.write("#" + i + " " + sum + "\n");
		} // T
		bw.flush();
	} // main

	private static int bfs() {
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				if(check(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Node(nr, nc, n.w+1));
					map[nr][nc] = n.w + 1;
				}
			}
			
		}
		return 0;
	}

	private static boolean check(int nr, int nc) {
		return 0 <= nr && N > nr && 0 <= nc && M > nc;
	}

} // class
