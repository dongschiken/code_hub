import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] visited = new int[node+1];
		ArrayList<Integer>[] grape = new ArrayList[node+1];
		for (int i = 0; i < node+1; i++) {
			grape[i] = new ArrayList(); 
		}
		
		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			grape[l].add(r);
			grape[r].add(l);
		}
		
		for (int i = 0; i < grape.length; i++) {
			Collections.sort(grape[i], Comparator.reverseOrder());
		}

		dfs(grape, visited, target);
		
		for (int i = 1; i < grape.length; i++) {
			bw.write(visited[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(ArrayList<Integer>[] grape, int[] visited, int target) {
		visited[target] = ++count;
		
		Iterator<Integer> ir = grape[target].iterator();
		while (ir.hasNext()) {
			Integer next = (Integer) ir.next();
			
			if( visited[next] == 0) dfs(grape, visited, next);
			
		}
	}

}