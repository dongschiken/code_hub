import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int[][] extend;
	static int[][] map;
	static int R, C, T;

	static int[][][] d = {
			// 오, 위, 왼, 아
			{{0, -1, 0, 1}, {1, 0, -1, 0}},
			// 오, 아, 왼, 위
			{{0, 1, 0, -1}, {1, 0, -1, 0}}
	};
	static int[][] cur = new int[2][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int c = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cur[c][0] = i;
					cur[c][1] = j;
					c++;
				}
			}
		}

		// 2가지 메서드
		// 확산
		// 시계, 반시계 방향대로 이동
		int val = 0;
		for (int i = 0; i < T /*- 1*/; i++) {
			diffusion();
			move();
		}


		for (int k = 0; k < R; k++) {
			for (int j = 0; j < C; j++) {
				if(map[k][j] > 0)val += map[k][j];
			}
		}
		System.out.println(val);
	}
	// 시계, 반시계 방향으로 이동
	public static void move() {
		extend = new int[R][C];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				extend[i][j] = map[i][j];
			}
		}
		int r = 0;
		int c = 0;
		for (int i = 0; i < 2; i++) {
			r = cur[i][0];
			c = cur[i][1];
			for (int k = 0; k < 4; k++) {
				while (true) {
					int pr = r;
					int pc = c;
					r += d[i][0][k];
					c += d[i][1][k];
					// 배열의 끝을 만나면 - 해서 이전 자리로 돌아감
					if(r < 0 || c < 0 || r >= R || c >= C) {
						r -= d[i][0][k];
						c -= d[i][1][k];
						break;
					}
					// 현재값이 -1일 때, 다음값이 -1일때
					if(map[pr][pc] == -1) {
						extend[r][c] = 0;
						continue;
					}
					if(map[r][c] == -1) {
						extend[r][c] = -1;
						break;
					}
					extend[r][c] = map[pr][pc];
				}
			}
		}
		// 로직이 전부 끝나면 map에 복사
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = extend[i][j];
			}
		}
	}
	// 확산 메서드
	public static void diffusion() {
		extend = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 배열 범위 밖, -1을 만나면 cnt X
				check(i, j);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = extend[i][j]; 
			}
		}
	}

	private static void check(int r, int c) {
		int cnt = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + d[0][0][k];
			int nc = c + d[0][1][k];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
			extend[nr][nc] += map[r][c] / 5;
			cnt++;
		}
		int cur = map[r][c] / 5;
		map[r][c] -= cur * cnt;
		extend[r][c] += map[r][c];
	}
}