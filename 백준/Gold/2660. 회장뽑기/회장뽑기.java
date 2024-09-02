import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class Main {

	static List[] list;
	static int[] visited;
	static int[] arr;
	static int N;
	static int min = Integer.MAX_VALUE;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 무방향 그래프
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList();
		}

		//temp[0] == null || Integer.parseInt(temp[0]) != -1 && Integer.parseInt(temp[1]) != -1
		String[] temp = new String[2];
		arr = new int[N + 1];
		while (true) {
			temp = br.readLine().split(" ");

			if(Integer.parseInt(temp[0]) == -1 && Integer.parseInt(temp[1]) == -1) break;

			int left = Integer.parseInt(temp[0]);
			int right = Integer.parseInt(temp[1]);
			list[left].add(right);
			list[right].add(left);
		}

		OUT :
			for (int i = 1; i <= N; i++) {
				visited = new int[N + 1];
				arr[i] = bfs(i);
                for (int k = 1; k < visited.length; k++) {
					if(visited[k] == 0) {
                        arr[i] = Integer.MAX_VALUE;
                        continue OUT;
                    }
                }
			}

		List<Integer> list = new ArrayList<>();
		int cnt = 0;
		for (int i = 1; i < arr.length; i++) {
			if(min == arr[i]) {
				cnt++;
				list.add(i);
			}
		}

		Collections.sort(list);
		bw.write(min+" "+list.size()+"\n");
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i)+" ");
		}
        bw.flush();
	}


	private static int bfs(int idx) {
		Queue<Integer> pq = new ArrayDeque<>();
		int cnt = 0;
		pq.offer(idx);
		visited[idx] = 1;
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			Iterator ir = list[cur].iterator();
			while (ir.hasNext()) {
				int x = (int) ir.next();
				if(visited[x] == 0) {
					visited[x] = visited[cur] + 1;
					cnt = Math.max(cnt, visited[x]);
					pq.offer(x); 
				}
			}
		}
        min = Math.min(min, cnt - 1);
		return cnt - 1;
	}
}
