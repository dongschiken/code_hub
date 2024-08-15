import java.io.*;
import java.util.*;

public class Main {
	
	static int R;
	static int C;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	static int[][] grape;
	static int[][] tempGrape;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int safeArea;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		grape = new int[R][C];

		// bfs 탐색하는데
		// 현재 2인 위치값들을 담아놓을 큐 생성
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				grape[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 3개의 좌표값에 1을 넣고
		// bfs 반복하면서 queue에 넣어놓은 2번 좌표를 돌면서 사방탐색, 1을 만나면 탐색 중지
		dfs(0);
		System.out.println(result);

	}

	public static void dfs(int stage){

		if(stage == 3){
			// 벽이 3개가 되면 bfs를 호출해서 최대 안전지역 찾는다.
			bfs();
			return;
		}

		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				// 만약 현재 위치가 0인경우 1을 넣어서 벽을 세운다.
				// 3까지 갔다가 돌아오면 그 위치를 0으로 다시 만들어준다.
				if(grape[i][j] == 0){
					grape[i][j] = 1;
					dfs(stage+1); // 벽 개수를 1개 늘려서 dfs 다시 호출
					grape[i][j] = 0;
				}
			}
		}
	}

	static int result = -1;
	private static void bfs() {
		tempGrape = new int[R][C];
		safeArea = 0;
		// 현재 바이러스가 있는 지점 큐에 넣고, 안전 지역 최대값을 찾기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempGrape[i][j] = grape[i][j];
				if(grape[i][j] == 2) {
					queue.offer(new int[] {i, j});
				}
				if(grape[i][j] == 0) {
					safeArea++;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			
			for (int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// visited를 만들어줘야하나?? 했는데 grape만으로 방문 체크할 수 있음
				// 바이러스 퍼트릴 수 있으면 안전지역 --
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && tempGrape[nr][nc] == 0) {
					tempGrape[nr][nc] = 2;
					queue.offer(new int[] {nr, nc});
					safeArea--;
				}
			}
		}
		result = Math.max(safeArea, result);
	}
}
