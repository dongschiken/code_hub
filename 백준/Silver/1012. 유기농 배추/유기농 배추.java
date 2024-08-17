import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] visited;
	static int[][] map;
	static int cnt;
	static int N;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new int[N][M];
			cnt = 0;
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				map[left][right] = 1;	
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(visited[j][j2] == 0 && map[j][j2] == 1) {
						bfs(j, j2);
						cnt++;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {r, c});
		
		while (!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];	
				
				if(check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] == 1) {
					visited[nr][nc] = 1;
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
