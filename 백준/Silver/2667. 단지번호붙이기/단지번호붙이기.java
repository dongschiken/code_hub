import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int[] cooX = new int[] {1, -1, 0, 0};
	static int[] cooY = new int[] {0, 0, 1, -1};
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int node = Integer.parseInt(br.readLine());
		int[][] grape = new int[node+2][node+2];
		int[][] visited = new int[node+2][node+2];
		ArrayList<Integer> danji = new ArrayList<Integer>();
		for (int i = 1; i <= node; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 1; j <= node; j++) {
				grape[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		br.close();
		int danjiCount = 0;
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if( grape[i][j] == 1 && visited[i][j] != 1) {
					dfs(i, j, grape, visited);
					danjiCount++;
					danji.add(count);
					count = 0;
				}
			}
		}
		bw.write(danjiCount+"\n");
		Collections.sort(danji);
		for (int i = 0; i < danjiCount; i++) {
			bw.write(danji.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void dfs(int x, int y, int[][] grape, int[][] visited) {
		visited[x][y] = 1;
		count++;
		for (int i = 0; i < 4; i++) {
			int newX = x + cooX[i];
			int newY = y + cooY[i];
			if(grape[newX][newY] == 1 && visited[newX][newY] != 1) {
				dfs(newX, newY, grape, visited);
			}
		}
		
	}

}

