import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] visited;
	static int[][] grape;
	static List<int[]> list = new ArrayList<>();
	static Queue<int[]> queue;
	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 안전거리 최대값
		// 1인위치 bfs 탐색
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grape = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grape[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 1 탐색하면서 최대값 구하기
		// 가장 가까운 1 만나면 탐색 종료
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(grape[i][j] != 1)
					bfs(new int[] {i, j});
			}
		}
		System.out.println(result);
	}

	static int result = 0;
	private static void bfs(int[] is) {
		queue = new ArrayDeque<>();
		visited = new int[N][M];
		queue.offer(is);
		visited[is[0]][is[1]] = 1;
		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			int r = cur[0];
			int c = cur[1];

			for (int i = 0; i < 8; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				if(check(nr, nc) && visited[nr][nc] == 0 && grape[nr][nc] == 1) {
					visited[nr][nc] = visited[r][c];
					//					System.out.println(nr+", "+nc);
					result = Math.max(result, visited[nr][nc]);
					return;
				}
				if(check(nr, nc) && visited[nr][nc] == 0) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new int[] {nr, nc});
				}
			}
		}

	}

	static private boolean check(int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) check = true;
		return check;
	}
}
