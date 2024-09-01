import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] visited;
	static char[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int cnt;
	static int max;
	static int N, M;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[26];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} 
		dfs(0, 0, 1);
		System.out.println(max);
	}


	private static void dfs(int r, int c, int value) {
		max = Math.max(max, value);
		
		visited[map[r][c] - 65] = 1;
		for (int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(check(nr, nc) && visited[map[nr][nc] - 65] == 0) {
				dfs(nr, nc, value + 1);
			}
		}
		visited[map[r][c] - 65] = 0;
	}
	
	private static boolean check(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
}
