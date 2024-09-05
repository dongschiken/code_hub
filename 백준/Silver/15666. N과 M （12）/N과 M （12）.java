import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new LinkedHashSet<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);
		dfs(0, 0);
		Iterator<String> ir = set.iterator();
		while (ir.hasNext()) {
			String string = (String) ir.next();
			bw.write(string);
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

	private static void dfs(int stage, int idx) throws IOException {
		if (stage == M) {
			for (int i = 1; i < M; i++) {
				if(sel[i] < sel[i - 1]) return;
			}
			for (int i = 0; i < M; i++) {
				bw.write(sel[i]+" ");
			}
			bw.write("\n");
			return;
		}
		int before = -1;
		for (int i = 0; i < N; i++) {
			if (before != data[i]) {
				sel[stage] = data[i];
				before = data[i];
				dfs(stage + 1, i + 1);
			}
		}
	}
}
