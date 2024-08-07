import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> queue = new LinkedList<>(); 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		int[][] visited = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) queue.offer(new int[] {i, j}); // 만약 1이라면 탐색 시작할 지점이니까 큐에 넣어놓는다.
			}
		}
		
		bfs(map, visited, queue);
		
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.print(max-1);
	}
	private static void bfs(int[][] map, int[][] visited, Queue<int[]> queue) {
		
		while (!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			visited[r][c] = 1;
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && visited[nr][nc] != 1 && map[nr][nc] == 0) {
					visited[nr][nc] = 1;
					map[nr][nc] = map[r][c]+1;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
