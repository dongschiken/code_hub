import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<int[]> list = new ArrayList<>();
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[r+1][c+1];
		for (int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				list.add(new int[]{0, Integer.parseInt(st.nextToken())});
				break;
			case 2:
				list.add(new int[]{r, Integer.parseInt(st.nextToken())});
				break;
			case 3:
				list.add(new int[]{Integer.parseInt(st.nextToken()), 0});
				break;
			default:
				list.add(new int[]{Integer.parseInt(st.nextToken()), c});
				break;
			}
		}
		
		int nr = list.get(N)[0];
		int nc = list.get(N)[1];
		int count = 1;
		do {
			if(nr == r) {
				nc += -1;
				map[nr][nc] = count++;
				if(nc == 0) {
					nr -= 1;
					map[nr][nc] = count++;
				}
			}else if(nc == 0) {
				nr -= 1;
				map[nr][nc] = count++;
				if(nr == 0) {
					nc += 1;
					map[nr][nc] = count++; 
				}
			}else if(nr == 0) {
				nc += 1;
				map[nr][nc] = count++;
				if(nc == c) {
					nr += 1;
					map[nr][nc] = count++;
				}
			}else {
				nr += 1;
				map[nr][nc] = count++;
				if(nr == r) {
					nc -= 1;
					map[nr][nc] = count++;
				}
			}
		} while (nr != list.get(N)[0] || nc != list.get(N)[1]);

		count -= 1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = map[list.get(i)[0]][list.get(i)[1]];
			sum += (Math.min(temp, count-temp));
		}
		System.out.println(sum);
		
	}
}
