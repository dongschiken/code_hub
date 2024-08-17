import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-2, -2, 1, -1, 2, 2, 1, -1};
	static int[] dc = {1, -1, 2, 2, 1, -1, -2, -2};
	static int N;
	static int[][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[] start;
	static int[] target;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			visited = new int[N][N];
			st = new StringTokenizer(br.readLine());
			start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			st = new StringTokenizer(br.readLine());
			target = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			queue.offer(start);
			visited[start[0]][start[1]] = 1;
			bfs();
			bw.write((visited[target[0]][target[1]]-1)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs() {
        
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
            
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
                
				if(check(nr, nc) && visited[nr][nc] == 0) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	private static boolean check(int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) check = true;
		return check;
	}
}
