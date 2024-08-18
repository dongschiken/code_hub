import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static Deque<Integer> deque = new ArrayDeque<>();
	static Map<Integer, Integer> map = new LinkedHashMap<>();
	static int[] visited;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			map.put(left, right);	
		}
		
		visited = new int[101];
		bfs();
		System.out.println(visited[100]-1);
	}


	private static void bfs() throws InterruptedException {
		deque.offer(1);
		visited[1] = 1;
		while (!deque.isEmpty()) {
			
			int cur = deque.poll();
			
			for (int i = 1; i <= 6; i++) {
				if(visited[100] != 0) return;
				int nd = cur + i;
				if(nd < 101) {
					// 맵에 넣어놓은 사다리, 뱀이 있는 경우 nd값을 사다리, 뱀의 value로 바꿔준다.
					if(map.containsKey(nd)) {
						nd = map.get(nd);
					}
					if(visited[nd] == 0){ 
						visited[nd] = visited[cur] + 1;
						deque.offer(nd);
					}
				}
			}
		}
	}
}