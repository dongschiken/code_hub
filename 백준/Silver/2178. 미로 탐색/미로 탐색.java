import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//
	static int comp = Integer.MAX_VALUE;
	static int[] dirx = new int[] {1, -1, 0, 0};
	static int[] diry = new int[] {0, 0, 1, -1};
	static int[][] dis = new int[102][102];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int node = 100;
		int[][] grape = new int[node+2][node+2];
		int[][] visited = new int[node+2][node+2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arvlX = Integer.parseInt(st.nextToken());
		int arvlY = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= arvlX; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 1; j <= arvlY; j++) {
				grape[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		
		bfs(1, 1, grape, visited, arvlX, arvlY);
		System.out.println(dis[arvlX][arvlY]);
		
		
	}

	private static void bfs(int x, int y, int[][] grape, 
			int[][] visited, int arvlX, int arvlY) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		dis[x][y] = 1;
		visited[x][y] = 1;
		queue.offer(x);
		queue.offer(y);
		while (!queue.isEmpty()) {
			x = queue.poll();
			y = queue.poll();
			if( x == arvlX && y == arvlY ) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int newX = x + dirx[i];
				int newY = y + diry[i];
				if(grape[newX][newY] == 1 && visited[newX][newY] != 1 ) {
					visited[newX][newY] = 1;
					queue.offer(newX);
					queue.offer(newY);
					dis[newX][newY] = dis[x][y] + 1;
				}
			}
			
		}
		
	}

}
