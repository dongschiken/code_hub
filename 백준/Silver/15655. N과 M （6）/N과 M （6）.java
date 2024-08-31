import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int[] map;
	static int[] sel;
	static Set<int[]> set = new LinkedHashSet<>();
	static int N, M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N];
		sel = new int[M];
		visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		dfs(0, 0);
        bw.flush();
        bw.close();
        br.close();
	}

	private static void dfs(int idx, int stage) throws IOException {
		if (stage == M) {
			for (int i = 0; i < M; i++) {
				bw.write(sel[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int j2 = idx; j2 < N; j2++) {
			if (!visited[j2]) {
				visited[j2] = true;
				sel[stage] = map[j2];
				dfs(j2 + 1, stage + 1);
				visited[j2] = false;
			}
		}
	}
}

//5 3
//1 7 5 4 3
