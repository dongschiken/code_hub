import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] grape;
		int[][] value;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		grape = new int[height][width];
		value = new int[height][width];
		Queue<Position> queue = new ArrayDeque<Position>();
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				int temp = Integer.parseInt(st.nextToken());
				grape[i][j] = temp;
				if(temp == 1) {
					Position position = new Position(j, i);
					queue.add(position);
				}
			}
		}
		
		bw.write(bfs(grape, value, queue, width, height)+"");
		bw.flush();
	}

	private static int bfs(int[][] grape, int[][] value, Queue<Position> queue, int width, int height) {
		int max = 0;
		
		while (!queue.isEmpty()) {
			Position position = queue.poll();
			int curX = position.getX();
			int curY = position.getY();
			
			for (int i = 0; i < 4; i++) {
				int newX = curX + dx[i];
				int newY = curY + dy[i];
				
				if(newX >= 0 && newX < width && newY >= 0 && newY < height && grape[newY][newX] != 1 && grape[newY][newX] != -1) {
					// 방문처리
					grape[newY][newX] = 1;
					value[newY][newX] = value[curY][curX] + 1;
					// 새로운 위치값
					queue.offer(new Position(newX, newY));
					max = Math.max(max, value[newY][newX]);
				}
			}	
		}
		// 0인 값이 하나라도 있다면 ( 방문 안한곳 )
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(grape[i][j] == 0) {
					return -1;
				}
			}
		}
		return max;
	}
}

class Position{

	int x;
	int y;
	
	public Position() {
		super();
	}

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
}
