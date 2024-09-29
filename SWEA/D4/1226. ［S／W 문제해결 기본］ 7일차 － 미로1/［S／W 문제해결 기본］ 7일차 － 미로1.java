import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	static int[][] map;
	static Queue<Node> q;
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Node() {
			super();
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 10; i++) {
			br.readLine();
			map = new int[16][16];
			visited = new boolean[16][16];
			q = new ArrayDeque<>();
			Node s = new Node();
			Node e = new Node();
			for (int r = 0; r < 16; r++) {
				String[] str = br.readLine().split("");
				for (int c = 0; c < 16; c++) {
					map[r][c] = Integer.parseInt(str[c]);
					if(map[r][c] == 2) {
						s.r = r; s.c = c;
					}
					if(map[r][c] == 3) {
						e.r = r; e.c = c;
					}
				}
			}
			bfs(s);
			int result = 0;
			result = visited[e.r][e.c] ? 1 : 0;
			bw.write("#"+i+" "+result+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(Node s) {
		visited[s.r][s.c] = true;
		q.offer(new Node(s.r, s.c));
		while (!q.isEmpty()) {
			Node n = q.poll();
			int r = n.r;
			int c = n.c;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr, nc)) continue;
				if(!visited[nr][nc] && (map[nr][nc] == 0 || map[nr][nc] == 3)) {
					visited[nr][nc] = true;
					q.offer(new Node(nr, nc));
				}
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= 16 || nc < 0 || nc >= 16;
	}
}
