import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 1, -1};
	static int[] dc = {1, 0, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int N = 19;
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean check = false;
		OUT :
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				// 검은색
				if(map[i][j] == 1) {
					check = checkOmok(map, i, j, 1, bw);

					// 흰색
				}else if(map[i][j] == 2){
					check = checkOmok(map, i, j, 2, bw);
				}
				
				if(check) break OUT;
			}
		}
		if(!check) bw.write("0");
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean checkOmok(int[][] map, int row, int col, int color, BufferedWriter bw) throws IOException {
		
		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nr = row;
			int nc = col;
			for (int j = 1; j <= 5; j++) {
				nr += dr[i];
				nc += dc[i];

				if(nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && map[nr][nc] == color) {
					count++;
				}else {
					break;
				}
			}
			if(count == 4) {
				switch (i) {
				case 0:
					if(col-1 >= 0 && map[row][col-1] == color) return false;
					break;
				case 1:
					if(row-1 >= 0 && map[row-1][col] == color) return false;
					break;
				case 2:
					if(row-1 >= 0 && col-1 >= 0 && map[row-1][col-1] == color) return false;
					break;
				default:
					if(row+1 < 19 && col-1 >= 0 && map[row+1][col-1] == color) return false;
					break;
				} 
				bw.write(color+"\n");
				bw.write((row+1)+" "+(col+1));
				return true;
			}
		}
		return false;
	}

}
