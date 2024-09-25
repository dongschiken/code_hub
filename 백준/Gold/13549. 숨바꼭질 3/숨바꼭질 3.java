import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		int result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		visited[N] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int v = curr[1];
			visited[x] = true;
			if(x == M) {
				min = Math.min(min, v);
			}
			
			int x1 = x + 1;
			int x2 = x - 1;
			int x3 = x * 2;
			
			if(x1 < 100001 && !visited[x1]) q.offer(new int[] {x1, v + 1});
			if(x2 >= 0 && !visited[x2]) q.offer(new int[] {x2, v + 1});
			if(x3 < 100001 && !visited[x3]) q.offer(new int[] {x3, v});
//			System.out.println(q);
		}
		return min;
	}

}
