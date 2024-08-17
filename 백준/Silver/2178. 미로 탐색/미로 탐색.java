import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] visited;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int N, M;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new int[N][M];
		map = new int[N][M];
		queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		visited[0][0] = 1;
		queue.offer(new int[] {0, 0});
		bfs();
		System.out.print(visited[N-1][M-1]);
	}


	private static void bfs() {
		
		while (!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			int r = cur[0];
			int c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] == 1) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new int[] {nr, nc});
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
