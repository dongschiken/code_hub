import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Cell {
		int r;
		int c;
		int originValue; // 초기배양시간값
		int curValue;	 // 현재배양시간값
		
		public Cell(int r, int c, int originValue, int curValue) {
			super();
			this.r = r;
			this.c = c;
			this.originValue = originValue;
			this.curValue = curValue;
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", originValue=" + originValue + ", curValue=" + curValue + "]";
		}
		
	}
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	static PriorityQueue<Cell> pq;
	static boolean[][] visited;
	
	static int N;
	static int M;
	static int K;
	
	static int size_N;
	static int size_M;
	static int start;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			size_N = K + N + 2;
			size_M = K + M + 2;
			start = K / 2 + 1;
			
			visited = new boolean[size_N][size_M];
			pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
				@Override
				public int compare(Cell o1, Cell o2) {
					return o2.originValue - o1.originValue; // 내림차순 정렬
				}
			});
			int temp = 0;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					if((temp = Integer.parseInt(st.nextToken())) > 0) {
						visited[r+start][c+start] = true;
						pq.offer(new Cell(r+start, c+start, temp, temp));
					}
				}
			}
			simulation();
			bw.write("#"+i+" "+pq.size()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void simulation() {
		Queue<Cell> queue = new ArrayDeque<>();
		// 시간기준으로 로직한번 돌기
		// 우선순위 큐에서 하나 꺼낸다.
		// 그 꺼낸 Cell에서 3번째값을 -- 해준다.
		// 그 친구가 음수라면 4방탐색한다.
		// 만약 양수라면 큐에넣는다.
		// 시간만큼 로직 돌기
		for (int i = 0; i < K; i++) {
			while (!pq.isEmpty()) {
				Cell cell = pq.poll();
				cell.curValue--;
				if(cell.curValue < 0) {
					for (int j = 0; j < 4; j++) {
						int nr = cell.r + dr[j];
						int nc = cell.c + dc[j];
						if(visited[nr][nc] == true) continue;
						visited[nr][nc] = true;
						queue.offer(new Cell(nr, nc, cell.originValue, cell.originValue));
					}
				}
				if(cell.originValue + cell.curValue == 0) continue;
				queue.offer(cell);
			}
			while (!queue.isEmpty()) {
				pq.offer(queue.poll());
			}
		}
	}
}
