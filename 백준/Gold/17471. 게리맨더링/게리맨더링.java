import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] values;
	static boolean[] sel;
	static int[] data;
	static int[] visitedOne;
	static int[] visitedTwo;
	static List<Integer>[] list;
	static int N, min = Integer.MAX_VALUE;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sel = new boolean[N + 1];
		data = new int[N + 1];
		values = new int[N + 1];
		visitedOne = new int[N + 1];
		visitedTwo = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			data[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(list));
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0)
				continue;
			for (int j = 0; j < num; j++) {
				int idx = Integer.parseInt(st.nextToken());
				list[i].add(idx);
			}
		}

		// 전부 0일때
		boolean check = false;
		List<Integer> zero = new ArrayList<>();
		for (int i = 1; i < list.length; i++) {
			if (list[i].size() != 0) {
				check = true;
			} else {
				zero.add(i);
			}
		}
		if (!check) {
			if(N == 2) {
				System.out.println(Math.abs(values[1] - values[2]));
			}else {
				System.out.println(-1);
			}
			return;
		}
		
		int zIdx = 0;
		for (int i = 1; i < list.length; i++) {
			if(list[i].size() != 0) {
				count++;
			}else {
				zIdx = i;
			}
		}
		
		// 0이 1개인 경우, 나머지가 연결된 경우
		List<Integer> tempList = new ArrayList<>();
		int[] visited = new int[N + 1];
		boolean c = true;
		if(count == N-1) {
			for (int i = 1; i < list.length; i++) {
				if(i != zIdx) {
					tempList.add(i);
					c = bfs(tempList, visited);
				}
			}
			
			if(c) {
				int sum1 = 0;
				for (int i = 1; i < values.length; i++) {
					if(i != zIdx) {
						sum1 += values[i];						
					}
				}
				System.out.println(Math.abs(sum1 - values[zIdx]));
				return;
			}
		}
		// 만약 연결이 끊긴 경우가 있다면
		// 부분집합 -> 10개의 선거구 -> 1024개
		// 만약 부분집합에서 0, 123456 이나오면 if문으로 처리
		// 부분집합 한개 구해서 그 부분집합에 있는 숫자를 제외한 나머지 가져오기
		dfs(0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	private static void dfs(int stage) {
		if (stage == N) {
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (sel[i])
					cnt++;
			}
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			
			int cntOne = 0;
			int cntTwo = 0;
			for (int i = 1; i <= N; i++) {
				if (sel[i])
					list1.add(data[i]);
				else
					list2.add(data[i]);
			}
			if (list1.size() == 0 || list1.size() == N || list2.size() == 0 || list1.size() == N)
				return;
			preprocess(list1, list2);
			return;
		}
		sel[stage] = false;
		dfs(stage + 1);
		sel[stage] = true;
		dfs(stage + 1);
	}

	private static void preprocess(List<Integer> list1, List<Integer> list2) {	
		// 156 | 243
		// 156 visited처리
		// 243 bfs
		// 243 visited처리
		// 156 bfs
		// 이렇게 했는데 visited가 남아있다. -> 안되는 로직이다.
		// 이렇게 했는데 visited가 안남아있다. -> 되는 로직이다.
		boolean check = true;
		visitedOne = new int[N + 1];
		for (int i = 0; i < list1.size(); i++) {
			visitedOne[list1.get(i)] = 1;
		}
		check = bfs(list2, visitedOne);
		if (!check)
			return;
		visitedTwo = new int[N + 1];
		for (int i = 0; i < list2.size(); i++) {
			visitedTwo[list2.get(i)] = 1;
		}
		check = bfs(list1, visitedTwo);

		// 두 경우에서 하나라도 false가 나오면 그건 안되는 로직이다.
		if (!check)
			return;

		// 되는 로직은 가중치 계산해서 min값으로 초기화
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < list1.size(); i++) {
			sum1 += values[list1.get(i)];
		}
		
		for (int i = 0; i < list2.size(); i++) {
			sum2 += values[list2.get(i)];
		}
		min = Math.min(min, Math.abs(sum1 - sum2));
	}

	private static boolean bfs(List<Integer> list1, int[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(list1.get(0));
		visited[list1.get(0)] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			Iterator<Integer> ir = list[cur].iterator();
			while (ir.hasNext()) {
				Integer next = (Integer) ir.next();
				if (visited[next] == 0) {
					queue.offer(next);
					visited[next] = 1;
				}
			}
		}
		boolean check = true;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == 0 /* && list[i].size() != 0 */)
				check = false;
		}
		return check;
	}
}