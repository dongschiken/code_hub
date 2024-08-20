import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int N;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// 1 ~ max 까지만 bfs 탐색 돌린다. 근데 방문기록 남기면서 bfs 탐색 몇번했는지를 cnt 해야한다.
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		int result = 0;
		for (int i = 1; i <= max; i++) {
			visited = new int[N][N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					// 방문 안했고, 탐색해야하는 숫자 이상이라면
					if(visited[j][j2] == 0 && map[j][j2] >= i) {
						bfs(i, j, j2);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}		
		System.out.println(result);
	}

	private static void bfs(int i, int j, int j2) {
		queue.offer(new int[] {j, j2});
		visited[j][j2] = 1;
		
		while (!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			int r = cur[0];
			int c = cur[1];
			
			for (int k = 0; k < 4; k++) {
				
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] >= i) {
					visited[nr][nc] = 1;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	static private boolean check(int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) check = true;
		return check;
	}
}
