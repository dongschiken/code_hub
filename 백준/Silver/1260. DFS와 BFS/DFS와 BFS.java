
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] grape;
	static boolean[] visited;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException, NumberFormatException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCount = Integer.parseInt(st.nextToken());
		int lineCount = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		grape = new int[nodeCount+1][nodeCount+1]; 
		visited = new boolean[nodeCount+1];
		for (int i = 0; i < lineCount; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			grape[one][two] = 1;
			grape[two][one] = 1;
		}
		
		dfs(v);
		bw.flush();
		bw.write("\n");
		visited = new boolean[nodeCount+1];
		visited[v] = true;
		queue.offer(v);
		bfs();
		bw.flush();

	}
	private static void bfs() throws IOException {
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			bw.write(cur +" ");
			for (int i = 0; i < visited.length; i++) {
				if( grape[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		
	}
	private static void dfs(int v) throws IOException {
		
		visited[v] = true;
		bw.write(v + " ");
		for (int i = 1; i < visited.length; i++) {
			if(grape[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	

}
