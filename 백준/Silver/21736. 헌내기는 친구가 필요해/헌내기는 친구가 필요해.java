
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static char grape[][];
	static boolean visited[][];
	static int[] dirR = { 1, -1, 0, 0 };
	static int[] dirL = { 0, 0 ,1, -1 };
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int campusGround = 603;
		grape = new char[campusGround][campusGround];
		visited = new boolean[campusGround][campusGround];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int myX = 0;
		int myY = 0;
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				grape[i+1][j+1] = temp.charAt(j);
				if( temp.charAt(j) == 'I') {
					myX = i+1;
					myY = j+1;
				}
			}
		}
				dfs(myX, myY);
				if( count == 0 ) {
					System.out.println("TT");
				}else {
					System.out.println(count);
				}
	}

	private static void dfs(int y, int x) {
		if( grape[y][x] == 'P') {
			count++;
		}
		visited[y][x] = true;
		for (int j2 = 0; j2 < 4; j2++) {
			int newY = y + dirR[j2];
			int newX = x + dirL[j2];
			if( (grape[newY][newX] == 'O' || grape[newY][newX] == 'P') && !visited[newY][newX]) {
				dfs(newY, newX);
			}
		}
	}

}
