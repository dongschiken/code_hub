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
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		visit = new boolean[N];
		data = new int[N];
		sel = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);
		dfs(0, 0);
		bw.flush();
		bw.close();
		br.close();
		
	}
	static String str = "";
	static int cnt = 0;
	private static void dfs(int idx, int stage) throws IOException {
		if (stage == M) {
			String temp = "";
			for (int i = 0; i < M; i++) {
				temp += sel[i];
				temp += " ";
			}
			if(str.contains(temp)) return;
			bw.write(temp);
			bw.write("\n");
			str += temp + " ";
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[stage] = data[i];
				dfs(i + 1, stage + 1);
				sel[stage] -= data[i];
				visited[i] = false;
			}
		}

	}
}
