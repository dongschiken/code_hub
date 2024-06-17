import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static boolean check = true;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		
		//
		for (int x = 0; x < testcase; x++) {
			check = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int link = Integer.parseInt(st.nextToken());
			int[] visited = new int[node+1];
			int[] set = new int[node+1];
			
			ArrayList<Integer>[] grape = new ArrayList[node+1];
			for (int i = 1; i < grape.length; i++) {
				grape[i] = new ArrayList();
			}
			
			for (int i = 0; i < link; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				grape[l].add(r);
				grape[r].add(l);
			}
			for (int i = 1; i < grape.length; i++) {
				dfs(i, grape, visited, set);
			}
			
			if( check ) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
		}
		bw.flush();
	}

	private static void dfs(int N, ArrayList<Integer>[] grape, int[] visited, int[] set) throws IOException {
		visited[N] = 1;
		Iterator ir = grape[N].iterator();
		while (ir.hasNext()) {
			Integer next = (Integer) ir.next();
			if( visited[next] != 1) {
				set[next] = (set[N] + 1) % 2;
				dfs(next, grape, visited, set);
			}else if(set[N] == set[next]) { 
				check = false;
			}
		}
	}

}
