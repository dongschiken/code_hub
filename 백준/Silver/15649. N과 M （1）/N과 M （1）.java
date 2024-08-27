import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N];
		dfs(0, 0);
        bw.flush();
        bw.close();
	}

	private static void dfs(int loop, int stage) throws Exception {
		
		if(stage == M) {
			for (int i = 0; i < M; i++) {
				bw.write((arr[i] + 1) + " ");
			}
			bw.write("\n");
			return;
		}
 		
		for (int j2 = 0; j2 < N; j2++) {
			if(!visited[j2]) {
				visited[j2] = true;
				arr[stage] = j2;
				dfs(j2 + 1, stage + 1);
				visited[j2] = false;
			}
		}
		
	}
}
