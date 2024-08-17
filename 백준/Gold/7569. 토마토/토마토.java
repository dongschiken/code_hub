import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {1, -1, 0, 0, 0, 0};
	static int[] dc = {0, 0, 1, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1}; 
	static int[][][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int zeroCnt;
	static int max = Integer.MIN_VALUE;
	static int C;
	static int R;
	static int H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		visited = new int[H][R][C];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < C; j2++) {
					visited[i][j][j2] = Integer.parseInt(st.nextToken());
					if(visited[i][j][j2] == 1) queue.offer(new int[] {i, j, j2});
					if(visited[i][j][j2] == 0) zeroCnt++;
				}
			}
		}
		bfs();
		if(zeroCnt != 0) System.out.println(-1);
		else if(max == Integer.MIN_VALUE) System.out.println(0);
		else System.out.println(max - 1);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			
			int cur[] = queue.poll();
			int h = cur[0];
			int r = cur[1];
			int c = cur[2];
			
			for (int i = 0; i < 6; i++) {
				
				int nh = h + dh[i];
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nh, nr, nc) && visited[nh][nr][nc] == 0) {
					visited[nh][nr][nc] = visited[h][r][c] + 1;
					max = Math.max(max, visited[nh][nr][nc]);
					zeroCnt--;
					queue.offer(new int[] {nh, nr, nc});
				}	
			}
		}
	}
	
	private static boolean check(int nh, int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < R && nc >= 0 && nc < C && nh >= 0 && nh < H) check = true;
		return check;
	}
}
