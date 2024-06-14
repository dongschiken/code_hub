import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] grape = new ArrayList[node+2];
		int[] visited = new int[node+1];
		int[] result = new int[node+1];
		for (int i = 0; i < grape.length; i++) {
			grape[i] = new ArrayList();
		}
		
		for (int i = 1; i <= link; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			grape[l].add(r);
			grape[r].add(l);
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < visited.length; i++) {
			
			bfs(i, grape, visited);
			int bacon = 0;
			for (int j = 1; j < visited.length; j++) {
				if( j == i ) continue;
				bacon += visited[j]-1;
			}
			result[i] = bacon;
			min = Math.min(min, result[i]);
			visited = new int[node+1];
		}
		
		for (int i = 1; i < result.length; i++) {
			if( result[i] == min ) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void bfs(int N, ArrayList<Integer>[] grape, int[] visited) {
		visited[N] = 1;
		Queue<Integer> queue = new ArrayDeque();
		queue.offer(N);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			Iterator<Integer> ir = grape[cur].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				if( visited[next] == 0 ) {
					queue.offer(next);
					visited[next] = visited[cur] + 1;
				}
			}
		}
	}

}
