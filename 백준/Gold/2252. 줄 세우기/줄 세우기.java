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

	public static void main(String[] args) throws IOException {
		// 내가 현재 진입차수가 0이면 큐에담는다. 아니면 큐에못담는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer>[] list = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
		
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			dist[b]++;
		}
		
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] == 0) {
				q.offer(i);
				bw.write(i+" ");
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			Iterator<Integer> ir = list[cur].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				dist[next]--;
				if(dist[next] == 0) {
					bw.write(next+" ");
					q.offer(next);
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
