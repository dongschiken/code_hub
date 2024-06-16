import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] visited = new int[100001];
		int[] position = new int[100001];
		if( start >= end ) {
			bw.write(start-end+"");
			bw.flush();
			return;
		}
		
		bfs(start, end, visited, position);
		bw.write(position[end]+"");
		bw.flush();
		
	}

	private static void bfs(int start, int end, int[] visited, int[] position) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		visited[start] = 1;
		position[start] = 0;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < 3; i++) {
				int temp = 0;
				if( i == 0 ) {
					temp = cur - 1;
				}else if( i == 1 ) {
					temp = cur + 1;
				}else {
					temp = cur*2;
				}
				if(temp > 0 && temp <= 100000 && visited[temp] != 1 && position[temp] == 0) {
					visited[temp] = 1;
					position[temp] = position[cur] + 1;
					queue.offer(temp);
				}
				if( position[end] != 0 ) {
					return;
				}
			}
			
			
		}
		
		
		
	}

}