import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] arr = new int[101][101];
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			for (int j = startY; j < endY; j++) {
				for (int j2 = startX; j2 < endX; j2++) {
					if( arr[j][j2] != 1 ) {
						arr[j][j2] = 1;
					}
				}
			}
		}
		int count = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(arr[i][j] == 1) {
					count += 1;
				}
			}
		}
		bw.write(count+"");
		bw.flush();
	}

}
