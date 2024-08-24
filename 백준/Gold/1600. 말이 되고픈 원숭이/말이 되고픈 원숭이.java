import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] visited;
	static int[][] grape;
	static Queue<int[]> queue;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	// 말일때 움직일 배열
	static int[] hdr = {-2, -2, 1, -1, 2, 2, 1, -1};
	static int[] hdc = {1, -1, 2, 2, 1, -1, -2, -2};
	static int K;
	static int N;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// 0번 갔을때의 최단거리
		// 1번 갔을때의 최단거리
		// 2번 갔을때의 최단거리
		// ....
		// k번 갔을때의 최단거리
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new int[N][M][K+1];
		grape = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grape[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 말형태로 이동할때만 장애물 건너띈다.
		// 원숭이는 장애물 있으면 갈 수 없다.
		bfs();
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < K+1; i++) {
			if(visited[N-1][M-1][i] != 0) {
				min = Math.min(min, visited[N-1][M-1][i]);				
			}
		}
		if(min == 0 || min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min-1);
		}
	}

	private static void bfs() {
		queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 1;
		
		while (!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			
			for (int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr, nc) && visited[nr][nc][cnt] == 0 && grape[nr][nc] != 1) {
					visited[nr][nc][cnt] = visited[r][c][cnt] + 1;
					queue.offer(new int[] {nr, nc, cnt});
				}
			}	
			// 현재 지점의 cnt가 K보다 작으면 말방탐색
			if(cnt < K) {
				for (int i = 0; i < 8; i++) {
					
					int nr = r + hdr[i];
					int nc = c + hdc[i];
					
					if(check(nr, nc) && visited[nr][nc][cnt+1] == 0 && grape[nr][nc] != 1) {
						visited[nr][nc][cnt+1] = visited[r][c][cnt] + 1;
						queue.offer(new int[] {nr, nc, cnt+1});
					}
				}
			}
		}
	}
	
	static boolean check(int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) check = true;
		return check;
	}
}
