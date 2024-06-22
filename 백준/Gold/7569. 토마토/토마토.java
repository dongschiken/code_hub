import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Point> queue = new ArrayDeque<Point>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][][] grape;
		int[][][] value;
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int box = Integer.parseInt(st.nextToken());
		grape = new int[box][height][width];
		value = new int[box][height][width];
		
		for (int i = 0; i < box; i++) {
			for (int j = 0; j < height; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < width; j2++) {
					int temp = Integer.parseInt(st.nextToken());
					if( temp == 1 ) {
						queue.offer(new Point(j2, j, i));
					}
					grape[i][j][j2] = temp;
				}
			}
		}
		
		int result = bfs(grape, value, queue, width, height, box);
		
		System.out.println(result);
	}

	private static int bfs(int[][][] grape, int[][][] value, Queue<Point> queue, int width, int height, int box) {
		int maxDay = 0;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int curX = point.getX();
			int curY = point.getY();
			int curZ = point.getZ();
			
				for (int j = 0; j < 6; j++) {
					int newX = curX + dx[j];
					int newY = curY + dy[j];
					int newZ = curZ + dz[j];
					
					if( newX >= 0 && newX < width && newY >= 0 && newY < height && newZ >= 0 && newZ < box && grape[newZ][newY][newX] != 1 && grape[newZ][newY][newX] != -1 ) {
						grape[newZ][newY][newX] = 1;
						value[newZ][newY][newX] = value[curZ][curY][curX] + 1;						
						queue.offer(new Point(newX, newY, newZ));
						maxDay = Math.max(maxDay, value[newZ][newY][newX]);
					}
				}
		}
		for (int i = 0; i < box; i++) {
			for (int j = 0; j < height; j++) {
				for (int j2 = 0; j2 < width; j2++) {
					if( grape[i][j][j2] == 0) {
						return -1;
					}
				}
			}
		}
		return maxDay;
	}
}
class Point{
	int x;
	int y;
	int z;
	
	public Point() {
		super();
	}
	
	public Point(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
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
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	
}