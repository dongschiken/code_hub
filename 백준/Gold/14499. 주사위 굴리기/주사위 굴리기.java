import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dice;
	static int[] tmp;
	static int[][] map;
	// 방향에 따른 인덱스 이동
	static int[][] d = {
			{2, 3, 1, 0, 4, 5}, // 동
			{3, 2, 0, 1, 4, 5}, // 서
			{4, 5, 2, 3, 1, 0}, // 남
			{5, 4, 2, 3, 0, 1}  // 북
	};
	static int N, M, x, y, C;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
//		3 3 1 1 9
//		1 2 3
//		4 0 5
//		6 7 8
//		1 3 2 2 4 4 1 1 3
		map = new int[N][M];
		dice = new int[6];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// 1 : 아랫면
		// 0 : 윗면
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				change(1);
				break;
			case 2:
				change(2);
				break;
			case 3:
				change(3);
				break;
			case 4:
				change(4);
				break;
			}
		}
		System.out.println(sb);
	}

	private static void change(int direction) {

		direction -= 1;
		int nx = x + dx[direction];
		int ny = y + dy[direction];
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
			return;
		}
		tmp = new int[6];
		for (int i = 0; i < dice.length; i++) {
			tmp[d[direction][i]] = dice[i];
		}

		for (int j = 0; j < dice.length; j++) {
			if(d[direction][j] == 1) {
				if(map[nx][ny] == 0) map[nx][ny] = tmp[d[direction][j]];
				else {
					tmp[d[direction][j]] = map[nx][ny];
					map[nx][ny] = 0;
				}
			}else if(d[direction][j] == 0) {
				sb.append(tmp[d[direction][j]]).append("\n");
			}
		}
		for (int i = 0; i < dice.length; i++) {
			dice[i] = tmp[i];
		}
		x = nx;
		y = ny;
		
	}
}
