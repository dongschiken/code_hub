import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, range;
	static int[][] map;
	static int[][] copyMap;
	static int[][] simulMap;
	static int maxKill;
	static List<Point> eList;
	static List<Point> aList;
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point() {}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		simulMap = new int[N + 1][M];
		eList = new ArrayList<>();
		aList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) eList.add(new Point(i, j));
			}
		}
		
		dfs(0, 0);
		System.out.println(maxKill);
	}

	private static void dfs(int start, int stage) {
		if(stage == 3) {
			simulation();
			return;
		}
		
		for (int j2 = start; j2 < M; j2++) {
//			map[N][j2] = Integer.MAX_VALUE;
			aList.add(new Point(N, j2));
			dfs(j2 + 1, stage + 1);
			aList.remove(aList.size() - 1);
		}
	}

	private static void simulation() {
		// 시뮬레이션 시간
		// 현재 궁수들의 위치를 통해 죽일 수 있는 적 찾아내고;
		List<Point> copyList = new ArrayList<>(eList);
		copyMap = new int[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			
			// 궁수 1명에 해당하는 공격할 수 있는 적 뽑기
			for (int j = 0; j < aList.size(); j++) {
				simulMap = new int[N][M];
				int r = aList.get(j).r;
				int c = aList.get(j).c;
				
				List<Point> tempList = new ArrayList<>();
				for (int k = 0; k < copyList.size(); k++) {
					if((Math.abs(r - copyList.get(k).r) + Math.abs(c - copyList.get(k).c)) <= range) {
						tempList.add(new Point(copyList.get(k).r, copyList.get(k).c));
					}
				}
				// 두 거리를 가져와서 궁수와의 거리와 비교, 두 거리가 같으면 그냥 리턴, 다를경우 왼쪽기준
				tempList.sort((p1, p2) -> {
					int dis1 = Math.abs(p1.r - r) + Math.abs(p1.c - c);
					int dis2 = Math.abs(p2.r - r) + Math.abs(p2.c - c);
					
					if(dis1 != dis2) {
						return Integer.compare(dis1, dis2);
					}else {
						return Integer.compare(p1.c, p2.c);
					}
				});
				if(tempList.size() == 0) continue;
				Point enemy = tempList.get(0);
				// 내가 병사를 죽였을 때 이미 배열에 들어있다면 제외
				if(copyMap[enemy.r][enemy.c] != 0) {
					copyMap[enemy.r][enemy.c] = 0; // 적팀 죽이기
					cnt++;
				}
			}
//			for (int[] m : copyMap) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println();
			for (int r = N - 1; r > 0; r--) {
				for (int c = 0; c < M; c++) {
					copyMap[r][c] = copyMap[r - 1][c];
				}
			}
			// 항상 맨 위값은 0으로 교체
			Arrays.fill(copyMap[i], 0);
			copyList.clear();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(copyMap[r][c] == 1) copyList.add(new Point(r, c));
				}
			}
		}
		maxKill = Math.max(maxKill, cnt);
	}
}
