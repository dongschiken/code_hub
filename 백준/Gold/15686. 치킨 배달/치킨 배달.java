import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<int[]> list = new ArrayList<>();
	static List<int[]> temp = new ArrayList<>();
	static int[][] map;
	static int result;
    static int min = Integer.MAX_VALUE;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) list.add(new int[] {i, j});
				if(map[i][j] == 1) temp.add(new int[] {i, j});
			}
		}
		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int loop, int stage) {
		if(stage == M) {
			distance();
			return;
		}
		
		for (int i = loop; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			map[r][c] = 3;
			dfs(i + 1, stage + 1);
			map[r][c] = 2;
		}
	}

	private static void distance() {
		// 좌표값으로 거리 구하기
		// Math.abs(r1 - r2) + Math.abs(c1 - c2)
		List<int[]> chickens = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 3) chickens.add(new int[] {i, j});
			}
		}
		int sum = 0;
		int result = 0;
        // 전체 집(1)을 돌면서 현재 3(남겨진 치킨집)의 좌표값과 절대값 계산해서 작은값으로 초기화
		for (int i = 0; i < temp.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < chickens.size(); j++) {
				int[] chicken = chickens.get(j);
				sum = (Math.abs(chicken[0] - temp.get(i)[0]) + Math.abs(chicken[1] - temp.get(i)[1]));
				min = Math.min(min, sum);
			}
			result += min;
		}
		min = Math.min(min, result);
	}
}

