import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static int[][][] tetromino = {
			{{0,0}, {0,1}, {0,2}, {0,3}}, {{0,0}, {0,1}, {1,0}, {1,1}}, {{1,0}, {1,1}, {1,2}, {0,2}}, {{0,0}, {1,0}, {1,1}, {1,2}},
			{{0,0}, {0,1}, {0,2}, {1,2}}, {{0,0}, {0,1}, {0,2}, {1,0}}, {{0,0}, {1,0}, {2,0}, {1,1}}, {{0,0}, {1,0}, {2,0}, {2,1}},
			{{0,1}, {1,1}, {2,1}, {2,0}}, {{0,0}, {0,1}, {1,1}, {2,1}}, {{0,0}, {0,1}, {1,0}, {2,0}}, {{0,0}, {0,1}, {0,2}, {1,1}},
			{{0,1}, {1,0}, {1,1}, {1,2}}, {{1,0}, {0,1}, {1,1}, {2,1}}, {{0,0}, {0,1}, {1,1}, {1,2}}, {{1,0}, {1,1}, {0,1}, {0,2}},
			{{0,0}, {1,0}, {1,1}, {2,1}}, {{0,1}, {1,1}, {1,0}, {2,0}}, {{0,0}, {1,0}, {2,0}, {3,0}}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		int r4 = 0;
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		
		for (int i = 0; i < tetromino.length; i++) {
			// [][][0] == r
			// [][][1] == c
			r1 = tetromino[i][0][0]; // r1
			c1 = tetromino[i][0][1]; // c1
			
			r2 = tetromino[i][1][0]; // r2
			c2 = tetromino[i][1][1]; // c2
			
			r3 = tetromino[i][2][0]; // r3
			c3 = tetromino[i][2][1]; // c3
			
			r4 = tetromino[i][3][0]; // r4
			c4 = tetromino[i][3][1]; // c4
			while (true) {
				if(cCheck(c1, c2, c3, c4)) break;
				if(rCheck(r1, r2, r3, r4)) break;
				int sum = 0;
				sum += map[r1][c1] + map[r2][c2] + map[r3][c3] +map[r4][c4];
				max = Math.max(max, sum);
				c1++;
				c2++;
				c3++;
				c4++;
				if(cCheck(c1, c2, c3, c4)) {
					r1++;
					r2++;
					r3++;
					r4++;
					c1 = tetromino[i][0][1];
					c2 = tetromino[i][1][1];
					c3 = tetromino[i][2][1];
					c4 = tetromino[i][3][1];
					if(rCheck(r1, r2, r3, r4)) {
						break;
					}
				}
		
			}
		}
		System.out.println(max);
	}
	
	private static boolean rCheck(int r1, int r2, int r3, int r4) {
		if(r1 >= N || r2 >= N || r3 >= N || r4 >= N) return true;
		return false;
	}

	private static boolean cCheck(int c1, int c2, int c3, int c4) {
		if(c1 >= M || c2 >= M || c3 >= M || c4 >= M) return true;
		return false;
	}
}
