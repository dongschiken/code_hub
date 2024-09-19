import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int b, w;

		public Node(int b, int w) {
			super();
			this.b = b;
			this.w = w;
		}

		public Node() {
			super();
		}

		@Override
		public String toString() {
			return "Node [b=" + b + ", w=" + w + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		List<Node>[] list = new ArrayList[N + 1];
		Set<Integer> set = new LinkedHashSet<>();
		int[] degree = new int[N + 1];
		int[] need = new int[N + 1];
		need[N] = 1;
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			set.add(a);
			list[a].add(new Node(b, w));
			degree[b]++;
		}
		for (int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) q.offer(i);
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			Iterator<Node> ir = list[curr].iterator();
			while (ir.hasNext()) {
				Node node = ir.next();
				int next = node.b;
				int w = node.w;
				degree[next]--;
				need[next] += need[curr] * w; 
				if(degree[next] == 0) {
					q.offer(next);
				}
			}
		}
		List<Integer> sortList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(!set.contains(i)) {
				sortList.add(i);
			}
		}
		Collections.sort(sortList);
		for (int i = 0; i < sortList.size(); i++) {
			bw.write(sortList.get(i)+" "+need[sortList.get(i)]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();	
	}
}
