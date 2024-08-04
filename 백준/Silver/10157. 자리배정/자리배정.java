import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int target;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(br.readLine());
		int[][] map = new int[r][c];
		int count = 1;
		int maxRow = r-1;
		int maxCol = c-1;
		int minRow = 0;
		int minCol = 0;
		OUT:
		while (c*r >= count) {
			
			for (int i = minRow; i < maxRow; i++) {
				if(check(i, minCol, count)) break OUT;
				map[i][minCol] = count++;
			}
			for (int i = minCol; i < maxCol; i++) {
				if(check(maxRow, i, count)) break OUT;
				map[maxRow][i] = count++;
			}
			for (int i = maxRow; i > minRow; i--) {
				if(check(i, maxCol, count)) break OUT;
				map[i][maxCol] = count++;
			}
			for (int i = maxCol; i > minCol; i--) {
				if(check(minRow, i, count)) break OUT;
				map[minRow][i] = count++;
			}
			maxRow--;
			maxCol--;
			minRow++;
			minCol++;
		}
		if(target != count) System.out.println(0);
		
	}
	static boolean check(int r, int c, int count) {
		
		if(count == target) {
			System.out.println((c+1)+" "+(r+1));
			return true;
		}
		return false;
	}
}
