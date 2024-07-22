import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int[][] colorPaper = new int[101][101];

		// +1한다.
		// 경계선 부분을 1로 만든다.
		// 4방향을 10개씩 1로 만들어준다.
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			for (int j = r; j < r+10; j++) {
				for (int j2 = c; j2 < c+10; j2++) {
					colorPaper[j][j2] = 1;
				}
			}
		}
		for (int j = 1; j <= 100; j++) {
			for (int j2 = 1; j2 <= 100; j2++) {
				if(colorPaper[j][j2] == 1) {
					for (int k = 0; k < 4; k++) {
						int nr = j + dr[k];
						int nc = j2 + dc[k];
						if(colorPaper[nr][nc] == 0) count++;
					}
				}
			}
		}

		bw.write(count+"");
		bw.flush();
	}
}
