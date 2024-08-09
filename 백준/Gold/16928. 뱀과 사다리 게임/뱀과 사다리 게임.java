import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 6칸을 더해준다.
	static int[] dc = {1, 2, 3, 4, 5, 6};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[101];
		Deque<Integer> queue = new ArrayDeque<>();
		int[] arr = new int[101];
		int[] visited = new int[101];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < ladder+snake; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i < list.length; i++) {
			list[i].add(i);
			if(map.get(i) != null) 
				list[i].add(map.get(i));

		}
		bfs(list, queue, arr, visited);
		System.out.println(arr[100]);
	}

	private static void bfs(List<Integer>[] list, Deque<Integer> queue, int[] arr, int[] visited) {
		queue.offer(list[1].get(0));
		visited[1] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			visited[cur] = 1;
			for (int i = 0; i < 6; i++) {
				if(visited[100] != 0) return;
				if(list[cur].size() > 1) {
//					System.out.println(cur);
					int next1 = list[cur].get(0);
					visited[next1] = 1;
					int next2 = list[cur].get(1);
					visited[next2] = 1;
					queue.offerFirst(next2);			
					arr[next2] = arr[cur];
					break;
				}else {
					int next = list[cur].get(0);
					next = next + dc[i];
					if(next <= 100 && visited[next] == 0) {
						arr[next] = arr[cur] + 1;
						visited[next] = 1;
						queue.offer(next);
					}
				}
				
			}
		}
	}
}