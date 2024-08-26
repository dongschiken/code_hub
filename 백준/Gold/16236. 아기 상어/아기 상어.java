import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<int[]> queue;
	static List<int[]> list;
	static int[][] visited;
	static int[][] map;
	static int N;
	static int sharkSize = 2;
	static int cnt = 0;
	static int[] sharkDirection;
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkDirection = new int[] { i, j };
					map[i][j] = 0;
				}
			}
		}

		do {
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && map[i][j] < sharkSize) {
						list.add(new int[] { i, j });
					}
				}
			}
			search(list);
			if(time == 0) break;
		} while (!list.isEmpty() && min != Integer.MAX_VALUE);
		System.out.println(time);
	}
	
	static int min;
	private static void search(List<int[]> list2) {
		List<int[]> tempList = new ArrayList<>();
		min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int[] tmp = distanceSearch(list.get(i)[0], list.get(i)[1]);
			min = Math.min(tmp[2], min);
			tempList.add(tmp);
		}

		if(min == Integer.MAX_VALUE) return;
		for (int i = 0; i < tempList.size(); i++) {
			if(min == tempList.get(i)[2]) {
//				System.out.println(tempList.get(i)[0] +", " + tempList.get(i)[1]);
				bfs(tempList.get(i)[0], tempList.get(i)[1]);
				break;
			}
		}
	}

	//	private static boolean minValueSearch(int value, int i, int j) {
	//		boolean check = false;
	//		queue = new ArrayDeque<>();
	//		visited = new int[N][N];
	//		visited[sharkDirection[0]][sharkDirection[1]] = 1;
	//		queue.offer(sharkDirection);
	//
	//		while (!queue.isEmpty()) {
	//			int[] cur = queue.poll();
	//			int r = cur[0];
	//			int c = cur[1];
	//
	//			for (int k = 0; k < 4; k++) {
	//				int nr = r + dr[k];
	//				int nc = c + dc[k];
	//				if (check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] <= sharkSize) {
	//					visited[nr][nc] = visited[r][c] + 1;
	//					queue.offer(new int[] { nr, nc });
	//				}
	//			}
	//		}
	//		if(value == visited[i][j] - 1) {
	//			bfs(i, j);
	//			check = true;
	//		}
	//		return check;
	//	}

	private static int[] distanceSearch(int i, int j) {
		int min = Integer.MAX_VALUE;
		queue = new ArrayDeque<>();
		visited = new int[N][N];
		visited[sharkDirection[0]][sharkDirection[1]] = 1;
		queue.offer(sharkDirection);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] <= sharkSize) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
		if(visited[i][j] != 0)
			return new int[] {i, j, Math.min(visited[i][j] - 1, min)};

		return new int[] {i, j, min};
	}

	private static void bfs(int i, int j) {
		queue = new ArrayDeque<>();
		visited = new int[N][N];
		// i, j 위치가 타겟
		// 그 위치까지 갈 수 있으면 찍는다.
		// 현재 상어의 위치값
		// 만약 상어가 타겟위치로 이동 못했으면 현재 위치값이 다시 상어한테 들어가고
		// 만약 상어가 타겟위치로 이동했으면 그 위치값이 상어한테 들어간다.
		// 시간초는 누적
		visited[sharkDirection[0]][sharkDirection[1]] = 1;
		queue.offer(sharkDirection);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] <= sharkSize) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
		if (visited[i][j] != 0) {
			// 타겟 위치로 이동할 수 있으면 상어의 위치 조정
			sharkDirection = new int[] { i, j };
			time += visited[i][j] - 1;
			map[i][j] = 0;
			cnt++;
			// 상어 사이즈 1 증가
			if (cnt == sharkSize) {
				sharkSize++;
				cnt = 0;
			}
		}
	}

	static boolean check(int nr, int nc) {
		boolean check = false;
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			check = true;
		return check;
	}
}
/*
 * 
3
1 0 0
6 6 6
6 9 6
 */