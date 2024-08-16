import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

	static boolean[][] visited;
	static int[][] grape;
	static List<Integer> list = new ArrayList<>();
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		grape = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			grape[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		} 
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && grape[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		bw.write(cnt+"\n");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		int cnt = 0;
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {

			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			cnt++;
			for (int k = 0; k < 4; k++) {

				int nr = r + dr[k];
				int nc = c + dc[k];

				if(check(nr, nc) && !visited[nr][nc] && grape[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});

				}
			}
		}
		list.add(cnt);
	}

	private static boolean check(int nr, int nc) {
		boolean check = false;
		if(nr >= 0 && nr < grape.length && nc >= 0 && nc < grape.length) check = true;
		return check;
	}
}