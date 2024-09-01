import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static int[] visited;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {-1, 1, 0, 0};
	static int N, M;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[26];
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt) {
		max = Math.max(cnt, max);
		
		// 현재 알파벳을 방문처리하고 4방탐색 하면서 해당하는 알파벳이 아닌곳을 방문
		visited[map[r][c] - 65] = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr, nc) && visited[map[nr][nc] - 65] == 0) {
				dfs(nr, nc, cnt + 1);
			}
		}
		// 재귀 리턴되고 돌아오면 방문처리 취소
		visited[map[r][c] - 65] = 0;
	}

	private static boolean check(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
}
