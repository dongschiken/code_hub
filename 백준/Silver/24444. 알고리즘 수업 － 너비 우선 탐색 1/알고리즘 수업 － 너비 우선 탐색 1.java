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
	static int count = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] grape = new ArrayList[node+1];
		int[] visited = new int[node+1];
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for (int i = 0; i < node+1; i++) {
			grape[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			grape[l].add(r);
			grape[r].add(l);
		}
		
		for (int i = 1; i < node+1; i++) {
			Collections.sort(grape[i]);
		}
		
		visited[start] = count++;
		queue.offer(start);
		bfs(grape, visited, start, queue);
		for (int i = 1; i < visited.length; i++) {
			bw.write(visited[i]+"\n");
		}
		bw.flush();
        bw.close();
        br.close();
	}

	private static void bfs(ArrayList[] grape, int[] visited, int start, Queue<Integer> queue) throws IOException {
		while (!queue.isEmpty()) {
			int cur = queue.poll();
				Iterator<Integer> ir = grape[cur].iterator();
				while (ir.hasNext()) {
					int target =   ir.next();
					if(visited[target] == 0) {
						visited[target] = count++;
						queue.offer(target);
					}
				}
				
		}
		
	}

}
