import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] grape;
	static int[] visited;
	// 바이러스 감염된 컴퓨터 카운트
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		grape = new int[N+1][N+1];
		visited = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			grape[left][right] = 1;
			grape[right][left] = 1;
		}
		visited[1] = 1;
		dfs(1);
		System.out.println(cnt);
	}

	private static void dfs(int node) {
		

		for (int i = 0; i < grape[node].length; i++) {
			if(visited[i] == 0 && grape[node][i] == 1) {
				cnt++;
				visited[i] = 1;
				dfs(i);
			}
		}
		
	}
}
