import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int time, cnt, sharkSize = 2;

	static class Shark {
		int r, c, d;

		public Shark(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		// 아기상어의 위치를 받아서 그 위치값을 수정하면서 크기 키우기, 물고기 먹기
		while (true) {
			Shark s = bfs(r, c);
			// 먹이를 못먹으면 끝
			if (s == null)
				break;
			r = s.r;
			c = s.c;
			time += s.d;
			cnt++;
			if (cnt == sharkSize) {
				sharkSize++;
				cnt = 0;
			}
		}
		System.out.println(time);
		sc.close();
	}

	private static Shark bfs(int r, int c) {
		// 거리를 기준으로 거리가 다르면 거리가 더 작은값, 같다면 행을 기준으로 행이 위쪽일 경우(값이 작다)
		// 마지막으로 열이 더 왼쪽(값이 작다)
		PriorityQueue<Shark> pq = new PriorityQueue<>((o1, o2)
				-> o1.d != o2.d ? o1.d - o2.d : o1.r != o2.r ? o1.r - o2.r : o1.c - o2.c);
		map[r][c] = 0;
		pq.offer(new Shark(r, c, 0));
		visited = new boolean[N][N];
		visited[r][c] = true;
		while (!pq.isEmpty()) {

			Shark cur = pq.poll();
			r = cur.r;
			c = cur.c;
			int d = cur.d;

			// 먹이를 먹었으면 현재 상어의 위치를 반환
			if (0 < map[r][c] && map[r][c] < sharkSize) {
				return new Shark(r, c, d);
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] <= sharkSize) {
					visited[nr][nc] = true;
					pq.offer(new Shark(nr, nc, d + 1));
				}
			}
		}
		return null;
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
}
