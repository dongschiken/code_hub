import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] list;
	static int[] node;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		node = new int[M];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					list[i].add(j);
					list[j].add(i);
				}	
			}
		}
		
		// 총 M - 1번 반복하면서 현재 노드에서 다음 노드를 찾을 수 있는지 확인
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M - 1; i++) {
			// 현재, 다음 노드
			if(!bfs(node[i], node[i+1])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}

	private static boolean bfs(int i, int j) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		visited[i] = true;
		queue.offer(i);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if(curr == j) {
				return true;
			}
			Iterator<Integer> ir = list[curr].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}	
		}
		return false;
	}
}
