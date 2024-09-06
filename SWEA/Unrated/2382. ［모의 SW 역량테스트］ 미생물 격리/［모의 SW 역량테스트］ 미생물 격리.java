import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K;
	// 상, 하, 좌, 우 순서
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static PriorityQueue<Microbe> pq = new PriorityQueue<>(new Comparator<Microbe>() {
		@Override
		public int compare(Microbe o1, Microbe o2) {
			return Long.compare(o2.w, o1.w);
		}
	});
	
	static long[][] map;
	static int[][] direc;

	static class Microbe {

		// 행, 열, 가중치, 이동방향
		// 이동방향 1 (상)
		// 이동방향 2 (하)
		// 이동방향 3 (좌)
		// 이동방향 4 (우)
		int r, c, d;
		long w;

		public Microbe(int r, int c, long w, int d) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Microbe [r=" + r + ", c=" + c + ", w=" + w + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pq.clear();
			map = new long[N][N];
			direc = new int[N][N];
			// 배열의 끝을 만나는 경우는 없음, 만약 배열의 c = 0 | r = 0 | c = N - 1 | r = N - 1 을 만나면 이동방향 반대로하고
			// 이동방향 반대는 1, 2는 3 - d | 3, 4는 7 - d
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				direc[r][c] = d;
				pq.offer(new Microbe(r, c, w, d));
				map[r][c] = w;
			}

			bfs();
			int sum = 0;
			for (int i1 = 0; i1 < N; i1++) {
				for (int j = 0; j < N; j++) {
					sum += map[i1][j];
				}
			}
			bw.write("#" + i + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		// 약품을 만나면 그 약품위치로 이동하고, 군집의 미생물이 절반 사망, 이동방향 reverse
		// 미생물 을 만나면 그 위치에 다른 미생물이 있을경우
		// 총 4개의 군집이 만나는 경우 어떻게 처리할 것인가
		// 상, 하, 좌, 우

		// 1개의 과정을 거치면서 임시 queue에 담고 pq에서 하나씩 빼면서 가중치 높은놈이 먼저 그 위치 방문하게 하기
		// 새로운 놈이 그 위치에 들어오면 가중치 높은놈이랑 비교할 필요없지않나??

	}

	private static void bfs() {
		// time만큼 돌리기
		for (int i = 0; i < M; i++) {
			long[][] temp = new long[N][N];

			while (!pq.isEmpty()) {

				Microbe mc = pq.poll();
				int nr = mc.r + dr[mc.d];
				int nc = mc.c + dc[mc.d];

				if (nr <= 0 || nr >= N - 1 || nc <= 0 || nc >= N - 1) {
					if(mc.d <= 2) 
					direc[nr][nc] = 3 - mc.d;
					else 
					direc[nr][nc] = 7 - mc.d;
					temp[nr][nc] += (long) Math.floor(map[mc.r][mc.c] / 2);
					continue;
				}
				if (temp[nr][nc] != 0) {
					temp[nr][nc] += map[mc.r][mc.c];
					continue;
				}
				if (temp[nr][nc] == 0) {
					temp[nr][nc] = map[mc.r][mc.c];
					direc[nr][nc] = mc.d;
					continue;
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(temp[j][j2] != 0) {
						pq.offer(new Microbe(j, j2, temp[j][j2], direc[j][j2]));
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = temp[j][j2];
				}
			}
		}
	}
}
