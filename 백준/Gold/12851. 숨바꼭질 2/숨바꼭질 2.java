import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int INF = 100001;
	static int[] arr = new int[INF];
	static int N, M, min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[INF];
		// 뭐가 필요할까??
		// 현재 위치, value
		// 음수 고려??
		bfs();
		System.out.println(min);
		System.out.println(cnt);
		
	}
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visited[N] = true;
		q.offer(new int[] {N, 0});
		
		while (!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int v = cur[1];
			visited[x] = true;
			if(v > min) continue;
			if(x == M) {
				if(min > v) {
					min = v;
					cnt = 1;
				} else if(min == v) {
					cnt++;
				}
			}
			
			int nx1 = x + 1;
			int nx2 = x - 1;
			int nx3 = x * 2;
			if(nx1 >= 0 && nx1 < INF && !visited[nx1]) {
				q.offer(new int[] {nx1, v + 1});
				if(nx1 == M) visited[nx1] = false;	
			}
			if(nx2 >= 0 && nx2 < INF && !visited[nx2]) {
				q.offer(new int[] {nx2, v + 1});
				if(nx2 == M) visited[nx2] = false;
			}
			if(nx3 >= 0 && nx3 < INF && !visited[nx3]) {
				q.offer(new int[] {nx3, v + 1});
				if(nx3 == M) visited[nx3] = false;	
			}
		}
	}
}
