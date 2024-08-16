import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] grape;
	static int[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		grape = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			grape[left][right] = 1;
			grape[right][left] = 1;
		}
		visited = new int[N+1];
		dfs(S);
		bw.write("\n");
		visited = new int[N+1];
		bfs(S);
		bw.flush();
		
	}

	private static void bfs(int s) throws IOException {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(s);
		visited[s] = 1;
		while (!queue.isEmpty()) {
			
			int cur = queue.poll();
			bw.write(cur+" ");
			for (int i = 1; i < grape[cur].length; i++) {
				if(visited[i] == 0 && grape[cur][i] == 1) {
					visited[i] = 1;
					queue.offer(i);
				}
			}
			
		}
		
	}

	private static void dfs(int node) throws IOException {
		
		visited[node] = 1;
		bw.write(node+" ");
		for (int i = 1; i < grape[node].length; i++) {
			if(visited[i] == 0 && grape[node][i] == 1) {
				dfs(i);
			}
		}
		
	}
}
