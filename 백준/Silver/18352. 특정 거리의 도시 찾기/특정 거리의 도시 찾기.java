import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] grape = new ArrayList[node+1];
		
		int[] visited = new int[node+1];
		for (int i = 0; i < node+1; i++) {
			grape[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			grape[l].add(r);
		}
		//System.out.println(Arrays.toString(grape));
		ArrayList<Integer> temp = new ArrayList();
		bfs(start, grape, visited);
		for (int i = 1; i < visited.length; i++) {
			if( visited[i] == (target+1) ) {
				temp.add(i);
			}
		}
		Collections.sort(temp);
		if( temp.isEmpty() ) {
			System.out.println(-1);
		}else {
			for (int i = 0; i < temp.size(); i++) {
				sb.append(temp.get(i)+"\n");
			}
			System.out.println(sb);
		}
	}

	private static void bfs(int start, ArrayList<Integer>[] grape, int[] visited) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		visited[start] = 1;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			Iterator<Integer> ir = grape[cur].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				if( visited[next] == 0 ) {
					queue.offer(next);
					visited[next] = visited[ cur]+1;
				}
			}
		}
	}

}
