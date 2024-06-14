import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] grape = new ArrayList[node+1];
		int[] visited = new int[node+1];
		int[] temp = new int[node+1];
		
		for (int i = 0; i < node+1; i++) {
			grape[i] = new ArrayList();
		}
		
		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			grape[l].add(r);
		}
		
		for (int i = 1; i < visited.length; i++) {
			bfs(i, grape, visited, temp);
			visited = new int[node+1];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < temp.length; i++) {
			max = Math.max(max, temp[i]);
		}
		
		for (int i = 1; i < temp.length; i++) {
			if( max == temp[i] ) {
				bw.write(i+" ");
			}
		}
		bw.flush();
		
	}

	private static void bfs(int N, ArrayList<Integer>[] grape, int[] visited, int[] temp) {
		visited[N] = 1;
		Queue<Integer> queue = new ArrayDeque();
		queue.offer(N);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			Iterator ir = grape[cur].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				if( visited[next] != 1 ) {
					queue.offer(next);
					visited[next] = 1;
					temp[next]++;
				}
			}
		}
		
	}

}
