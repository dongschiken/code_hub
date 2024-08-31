import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] abc = new int[3];
	// A -> B, B -> C, A -> C, B -> A, C -> A, C -> B : 6가지
	static int[] dr = { 0, 0, 1, 1, 2, 2 };
	static int[] dc = { 1, 2, 0, 2, 0, 1 };
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	static Set<Integer> set = new LinkedHashSet<>();
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		abc[0] = Integer.parseInt(st.nextToken());
		abc[1] = Integer.parseInt(st.nextToken());
		abc[2] = Integer.parseInt(st.nextToken());

		visited = new boolean[201][201];

		bfs();
		list = new ArrayList<>(set);
		Collections.sort(list);
		for (Integer i : list) {
			bw.write(i+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs() {
		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		set.add(abc[2]); // 어차피 A : 0, B : 0일때는 C는 최대값이니까

		while (!queue.isEmpty()) {
			
			int cur[] = queue.poll();
			int a = cur[0];
			int b = cur[1];
			int c = abc[2] - (a + b);
			
			for (int i = 0; i < 6; i++) {
				int[] data = new int[] { a, b, c };
				data[dc[i]] += data[dr[i]];
				data[dr[i]] = 0;
				
				// 물통의 범위가 넘어서면 넘어선 물통에서 넘어선 값만큼 빼주고, 주는 물통에서는 넘어선 값만큼 다시 더해준다.
				for (int j = 0; j < 3; j++) {
					if(dc[i] == j && abc[j] < data[dc[i]]) {
						int tmp = data[dc[i]] - abc[j];
						data[dc[i]] -= tmp;
						data[dr[i]] += tmp;
					}
				}
				
				// 무조건 a, b의 방문체크만 하고, true로 만든다.
				if(!visited[data[0]][data[1]]) {
					visited[data[0]][data[1]] = true;
					queue.offer(new int[] {data[0], data[1]});
				}
				
				// 0번방이 0일때 2번방의 값을 set에 넣는다. -> 중복값 X
				if(a == 0) {
					set.add(c);
				}
	
			}
		}
		

	}
}
