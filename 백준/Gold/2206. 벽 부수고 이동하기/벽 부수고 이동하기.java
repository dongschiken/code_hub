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
import java.util.StringTokenizer;

public class Main {

	static int[][][] visited;
	static int[][] grape;
	static int N;
	static int M;
	static Queue<int[]> queue; // 현재 위치값 + 현재 위치가 벽을 부쉈는지 안부쉈는지 체크하는 숫자 0, 1
	static List<int[]> list = new ArrayList<>();
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grape = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				grape[i][j] = Integer.parseInt(temp[j]);
				if(grape[i][j] == 1)list.add(new int[] {i, j});
			}
		}

		// 벽을 한개 부수고 bfs() 호출
		// dfs(0, 0);
		bfs();
		int min = Integer.MAX_VALUE;
		if(visited[N-1][M-1][0] != 0 && visited[N-1][M-1][1] != 0) {
			min = Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]);
			System.out.println(min);        
		}else if(visited[N-1][M-1][0] != 0 || visited[N-1][M-1][1] != 0) {
			System.out.println(Math.max(visited[N-1][M-1][0], visited[N-1][M-1][1]));
		}else {
			System.out.println(-1);
		}

	}

	//	private static void dfs(int loop, int stage) {
	//		if(stage == 1) {
	//			bfs();
	//			return;
	//		}
	//		for (int i = 0; i < list.size(); i++) {
	//			int[] temp = list.get(i);
	//			grape[temp[0]][temp[1]] = 0;
	//			dfs(i+1, stage+1);
	//			grape[temp[0]][temp[1]] = 1;
	//		}
	//	}

	static int result = Integer.MAX_VALUE;
	private static void bfs() {
		queue = new ArrayDeque<>();
		visited = new int[N][M][2];
		queue.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 1;  // r == 0, c == 0이고 벽을 부수지 않은 경우

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			int r = cur[0];
			int c = cur[1];
			int status = cur[2]; // 벽을 부순상태 1, 부수지 않은 상태 0


			for (int i = 0; i < 4; i++) {

				int nr = r + dr[i];
				int nc = c + dc[i];

				// 현재 벽을 부순상태에서 이동
				if(check(nr, nc) && status == 1 && visited[nr][nc][1] == 0 && grape[nr][nc] == 0) {
					visited[nr][nc][1] = visited[r][c][1] + 1;
					queue.offer(new int[] {nr, nc, 1});
				}
				// 벽을 부수지 않은 상태에서 이동
				if(check(nr, nc) && status == 0 && visited[nr][nc][0] == 0 && grape[nr][nc] == 0) {
					visited[nr][nc][0] = visited[r][c][0]  + 1;
					queue.offer(new int[] {nr, nc, 0});
				}else if(check(nr, nc) && status == 0 && visited[nr][nc][0] == 0 && grape[nr][nc] == 1) {
					visited[nr][nc][1] = visited[r][c][0] + 1;
					queue.offer(new int[] {nr, nc, 1});
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) check = true;
		return check;
	}
}
