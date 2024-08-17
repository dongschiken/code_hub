import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] visited;
	static Queue<Integer> queue;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new int[100001];
		queue = new ArrayDeque<>();	
		visited[N] = 1;
		queue.offer(N);
		bfs();
		System.out.print(visited[M] - 1);
		sc.close();
	}

	private static void bfs() {
		
		while (!queue.isEmpty()) {
			
			int cur = queue.poll();
			//  현재위치 - 1
			//  현재위치 + 1
			//  현재위치 * 2
			int[] nd = new int[3];
			nd[0] = cur - 1;
			nd[1] = cur + 1;
			nd[2] = cur * 2;
			
			for (int i = 0; i < 3; i++) {
				
				if(nd[i] >= 0 && nd[i] < visited.length && visited[nd[i]] == 0) {
					visited[nd[i]] = visited[cur] + 1;
					queue.offer(nd[i]);
				}
			}
            if(visited[M] != 0) return;
		}
	}
}
