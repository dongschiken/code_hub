import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static int sum;
	static int[][] map;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> house = new ArrayList<>();
	static List<int[]> tempList = new ArrayList<>();
	
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
				if(map[i][j] == 1) house.add(new int[] {i, j});
			}
		}
		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int stage, int idx) {
		if(stage == M) {
			distance();
			return;
		}
		
		for (int j = idx; j < list.size(); j++) {
			tempList.add(new int[] {list.get(j)[0], list.get(j)[1]});
			dfs(stage + 1, j + 1);
			tempList.remove(tempList.size() - 1);
		}
		
	}

	private static void distance() {
		sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int[] h = house.get(i);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < tempList.size(); j++) {
				int r = tempList.get(j)[0];
				int c = tempList.get(j)[1];
				min = Math.min(min, Math.abs(h[0] - r) + Math.abs(h[1] - c));
			}
			sum += min;
		}
		result = Math.min(sum, result);
	}
}
