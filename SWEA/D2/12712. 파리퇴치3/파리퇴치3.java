import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	// 0~3 상하좌우, 4~7 대각선
	static int[] dr = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dc = {0, 0, 1, -1, 1, 1, -1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] map;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int killCount = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int j = 0; j < N; j++) {
				map[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
			}
			int max = -1;
			int temp = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					max = Math.max(max, catchFly(r, c, map, killCount));
				}
			}
			bw.write("#"+i+" "+max+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int catchFly(int r, int c, int[][] map, int killCount) {
		int leng = map.length;
		int sum1 = map[r][c];
		int sum2 = map[r][c];
		for (int i = 0; i < 4; i++) {
			
			int nr = r;
			int nc = c;
			
			for (int j = 0; j < killCount-1; j++) {
				nr += dr[i];
				nc += dc[i];
				if(nr >= 0 && nr < leng && nc >= 0 && nc < leng) {
					sum1 += map[nr][nc];
				}
			}
			
			nr = r;
			nc = c;
			for (int j = 0; j < killCount-1; j++) {
				nr += dr[i+4];
				nc += dc[i+4];
				if(nr >= 0 && nr < leng && nc >= 0 && nc < leng) {
					sum2 += map[nr][nc];
				}
			}
		}
		
		return Math.max(sum1, sum2);
	}
}
