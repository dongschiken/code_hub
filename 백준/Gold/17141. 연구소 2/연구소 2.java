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

	static int N;
	static int virus;
	// 그래프로 방문체크하면서 이 전방 + 1
	static int[][] grape;
	static int[][] tempGrape;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static List<int[]> list = new ArrayList<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		virus = Integer.parseInt(st.nextToken());
		grape = new int[N][N];
		// 바이러스 갯수 만큼 되면 bfs 순회시작
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grape[i][j] = Integer.parseInt(st.nextToken());
				if (grape[i][j] == 2) {
					list.add(new int[] { i, j });
				}
			}
		}
		dfs(0, 0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}

	static void dfs(int loop, int stage) {
		if (stage == virus) {
			int maxTime = bfs();
            if (maxTime != -1) { // 유효한 경우에만 비교
                result = Math.min(result, maxTime);
            }
            return;
		}

		for (int i = loop; i < list.size(); i++) {
			int[] temp = list.get(i);
			grape[temp[0]][temp[1]] = 3;
			dfs(i + 1, stage + 1);
			grape[temp[0]][temp[1]] = 2;
		}
	}

	static int result = Integer.MAX_VALUE;

	private static int bfs() {
		queue = new ArrayDeque<>();
		visited = new boolean[N][N];
		tempGrape = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tempGrape[i][j] = grape[i][j];
				if (grape[i][j] == 3) {
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					tempGrape[i][j] = 0;
				}
			}
		}
		int maxTime = 0;
		while (!queue.isEmpty()) {

			int[] temp = queue.poll();

			int r = temp[0];
			int c = temp[1];
			// 3인것을 빼내서 0으로 만든다.

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& tempGrape[nr][nc] != 1) {
					tempGrape[nr][nc] = tempGrape[r][c] + 1;
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
					maxTime = Math.max(maxTime, tempGrape[nr][nc]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && (tempGrape[i][j] == 0 || tempGrape[i][j] == 2)) {
					return -1;
				}
			}
		}
		return maxTime;
	}
}

