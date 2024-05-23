import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static boolean grape[][];
	static boolean visited[][];
	static int[] dirR = { 1, -1, 0, 0 };
	static int[] dirL = { 0, 0 ,1, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int cabbage = Integer.parseInt(st.nextToken());
			int maxFiled = 60;
			
			grape = new boolean[maxFiled][maxFiled];
			visited = new boolean[maxFiled][maxFiled];
			
			
			for (int j = 0; j < cabbage; j++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				grape[l+1][r+1] = true;
			}
			int answer = 0;
			for (int j = 1; j < width+1; j++) {
				for (int j2 = 1; j2 < height+1; j2++) {
					if( grape[j][j2] && !visited[j][j2]) {
						dfs(j, j2);
						answer += 1;
					}
				}
			}
			System.out.println(answer);
		}
		
		

	}
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int j2 = 0; j2 < 4; j2++) {
			int newY = y + dirR[j2];
			int newX = x + dirL[j2];
			if( grape[newY][newX] && !visited[newY][newX]) {
				dfs(newY, newX);
			}
		}
	}
}
