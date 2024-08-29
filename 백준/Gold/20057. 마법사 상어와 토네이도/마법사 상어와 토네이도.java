import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int remaind;
	static int[] sr = {};
	static int[] sc = {};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int count = 0;
		int distance = 1;
		int r = N / 2;
		int c = N / 2;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		OUT:	
			while (true) {
				for (int i = 0; i < distance; i++) {
					c--;
					left(r, c);
					if(check(r, c)) break OUT;
				}
				cnt++;
				for (int i = 0; i < distance; i++) {
					r++;
					down(r, c);
					if(check(r, c)) break OUT;
				}
				cnt++;
				if(cnt == 2) {
					distance++;
					cnt = 0;
				}
				for (int i = 0; i < distance; i++) {
					c++;
					right(r, c);
					if(check(r, c)) break OUT;
				}
				cnt++;
				for (int i = 0; i < distance; i++) {
					r--;
					up(r, c);
					if(check(r, c)) break OUT;
				}
				cnt++;
				if(cnt == 2) {
					distance++;
					cnt = 0;
				}
			}
		
		System.out.println(remaind);
		
	}

	private static void up(int r, int c) {
		
		int curValue = map[r][c];
		int remain = 0;
		remain += move(r, c+1, (int)(curValue * 0.07));
		remain += move(r, c+2, (int)(curValue * 0.02));
		remain += move(r+1, c+1, (int)(curValue * 0.01));
		remain += move(r-1, c+1, (int)(curValue * 0.1));
		remain += move(r, c-1, (int)(curValue * 0.07));
		remain += move(r, c-2, (int)(curValue * 0.02));
		remain += move(r+1, c-1, (int)(curValue * 0.01));
		remain += move(r-1, c-1, (int)(curValue * 0.1));
		remain += move(r-2, c, (int)(curValue * 0.05));
		
		move(r-1, c, curValue - remain);
		map[r][c] = 0;
		
	}

	private static void right(int r, int c) {
		
		int curValue = map[r][c];
		int remain = 0;
		remain += move(r-1, c, (int)(curValue * 0.07));
		remain += move(r-2, c, (int)(curValue * 0.02));
		remain += move(r-1, c-1, (int)(curValue * 0.01));
		remain += move(r-1, c+1, (int)(curValue * 0.1));
		remain += move(r+1, c, (int)(curValue * 0.07));
		remain += move(r+2, c, (int)(curValue * 0.02));
		remain += move(r+1, c-1, (int)(curValue * 0.01));
		remain += move(r+1, c+1, (int)(curValue * 0.1));
		remain += move(r, c+2, (int)(curValue * 0.05));
		
		move(r, c+1, curValue - remain);
	}

	private static void down(int r, int c) {
		
		int curValue = map[r][c];
		int remain = 0;
		remain += move(r, c+1, (int)(curValue * 0.07));
		remain += move(r, c+2, (int)(curValue * 0.02));
		remain += move(r-1, c+1, (int)(curValue * 0.01));
		remain += move(r+1, c+1, (int)(curValue * 0.1));
		remain += move(r, c-1, (int)(curValue * 0.07));
		remain += move(r, c-2, (int)(curValue * 0.02));
		remain += move(r-1, c-1, (int)(curValue * 0.01));
		remain += move(r+1, c-1, (int)(curValue * 0.1));
		remain += move(r+2, c, (int)(curValue * 0.05));
		
		move(r+1, c, curValue - remain);
		map[r][c] = 0;
	}

	private static void left(int r, int c) {
		
		int curValue = map[r][c];
		int remain = 0;
		remain += move(r-1, c, (int)(curValue * 0.07));
		remain += move(r-2, c, (int)(curValue * 0.02));
		remain += move(r-1, c+1, (int)(curValue * 0.01));
		remain += move(r-1, c-1, (int)(curValue * 0.1));
		remain += move(r+1, c, (int)(curValue * 0.07));
		remain += move(r+2, c, (int)(curValue * 0.02));
		remain += move(r+1, c+1, (int)(curValue * 0.01));
		remain += move(r+1, c-1, (int)(curValue * 0.1));
		remain += move(r, c-2, (int)(curValue * 0.05));
		
		move(r, c-1, curValue - remain);
		map[r][c] = 0;
	}
	
	private static int move(int r, int c, int value) {
		if(r < 0 || r >= N || c < 0 || c >= N) {
			remaind += value;
			return value;
		}else {
			map[r][c] += value;
			return value;
		}
	}

	private static boolean check(int r, int c) {
		return (r == 0 && c == 0);
	}
}
