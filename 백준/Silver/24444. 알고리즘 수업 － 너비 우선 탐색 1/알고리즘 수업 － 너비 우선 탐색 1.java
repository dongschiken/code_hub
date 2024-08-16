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
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] list;
	static int[] visited;
	static Queue<Integer> queue;
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new int[N+1];
		queue = new ArrayDeque<Integer>();
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			list[left].add(right);
			list[right].add(left);
		}
		
		for (List<Integer> list : list) {
			Collections.sort(list);
		}
		
		bfs(S);
		for (int i = 1; i < visited.length; i++) {
			bw.write(visited[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int s) {
		
		queue.offer(s);
		visited[s] = cnt++;
		while (!queue.isEmpty()) {
			
			int n = queue.poll();
			
			Iterator<Integer> ir = list[n].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				if(visited[next] == 0) {
					visited[next] = cnt++;
					queue.offer(next);
				}
			}
		}
	}
}
