import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] grape;
	static boolean[] visited;
	static int count = 0;
	static int temp[];
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		grape = new int[node+1][node+1];
		visited = new boolean[node+1];
		temp = new int[node+1];
		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			grape[l][r] = 1;
			grape[r][l] = 1;
		}
		temp[0] = 1;
		boolean tbool = true;
		while (true) {
			for (int i = 1; i <= node; i++) {
				if(temp[i] == 0) {
					count++;
					dfs(i);
				}
			}
			for (int i = 0; i < node; i++) {
				if( temp[i] == 0 ) tbool = false;
			}
			if( tbool == true ) break; 
		}
		System.out.println(count);
	}
	private static void dfs(int i) throws IOException {
		temp[i] = 1;
		visited[i] = true;
		for (int j = 0; j < grape.length; j++) {
			if(grape[i][j] == 1 && !visited[j] ) {
				dfs(j);
			}
		}
	}

}
