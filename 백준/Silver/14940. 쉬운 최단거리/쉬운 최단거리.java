import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int grape[][];
	static int visited[][];
	static int count = 0;
	static int[] cdrL = {-1, 1, 0, 0};
	static int[] cdrR = {0, 0, 1, -1};
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	public static void main(String[] args) throws IOException {
		
		grape = new int[1003][1003];
		visited = new int[1003][1003];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int myX = 0;
		int myY = 0;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) {
				grape[i][j] = Integer.parseInt(st.nextToken());
				if( grape[i][j] == 2) {
					myX = j;
					myY = i;
				}else if(grape[i][j] == 0) {
					visited[i][j] = 0;
				}else if(grape[i][j] == 1) {
					visited[i][j] = -1;
				}
			}
		}
		int v = 0;
		bfs(myY, myX, v);
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				bw.write(visited[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		
	}
	private static void bfs(int myY, int myX, int v) {
		queue.offer(new int[] {myY, myX, v});
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			
			myY = cur[0];
			myX = cur[1];
			v = cur[2];
			
			for (int i = 0; i < 4; i++) {
				if( grape[myY+cdrL[i]][myX+cdrR[i]] == 1 && visited[myY+cdrL[i]][myX+cdrR[i]] == -1) {
					visited[myY+cdrL[i]][myX+cdrR[i]] = v+1;
					queue.offer(new int[] {myY+cdrL[i], myX+cdrR[i], v+1});
				}
			}
		}
	}

}
