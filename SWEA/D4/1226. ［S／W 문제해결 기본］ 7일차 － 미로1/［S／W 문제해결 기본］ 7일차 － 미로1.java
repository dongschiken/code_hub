import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	static Queue<Node> q;
	static int[][] map;
	static Node e, s;
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
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10;
		for (int i = 1; i <= T; i++) {
			br.readLine();
			map = new int[16][16];
			visited = new boolean[16][16];
			q = new ArrayDeque<>();
			for (int j = 0; j < map.length; j++) {
				String[] str = br.readLine().split("");
				for (int j2 = 0; j2 < map[j].length; j2++) {
					map[j][j2] = Integer.parseInt(str[j2]);
					if(map[j][j2] == 2) s = new Node(j, j2);
					if(map[j][j2] == 3) e = new Node(j, j2);
				}
			}
			bfs();
			if(visited[e.r][e.c]) bw.write("#"+i+" "+1+"\n");
			else bw.write("#"+i+" "+0+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs() {
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
					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return (nr < 0 || nr >= 16 || nc < 0 || nc >= 16);
	}

}
