import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] arsg) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[1001][1001];
		ArrayList<int[]> list = new ArrayList<int[]>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x_index = Integer.parseInt(st.nextToken());
			int y_index = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int j = 1; j <= x_index; j++) {
				for (int j2 = 1; j2 <= y_index; j2++) {
					arr[x+j][y+j2] = (i+1);
				}
			}
			list.add(new int[] {x, y, x_index, y_index});
		}
		for (int i = 0; i < N; i++) {
			int count = 0;
			int[] temp = list.remove(0);
			int x = temp[0];
			int y = temp[1];
			int x_index = temp[2];
			int y_index = temp[3];
			for (int j = 1; j <= x_index; j++) {
				for (int j2 = 1; j2 <= y_index; j2++) {
					if(arr[x+j][y+j2] == (i+1)) {
						count += 1;
					}
				}
			}
			bw.write(count+"\n"); 
		}
		bw.flush();
	}

}
