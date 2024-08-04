import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < dice[i].length; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		int sum = 0;
		int max = 0;
		int bottomIdx = 0;
		int topIdx = 0;
		// 총 6번을 반복한다.
		for (int i = 0; i < dice[0].length; i++) {
			bottomIdx = i;
			topIdx = 0;
			// 현재 위치와 그 윗면을 제외한 나머지에서 max를 구하고 sum에 더해준다.
			// 윗면을 아랫면으로 잡는다.
			for (int j = 0; j < N; j++) {
				
				//topIdx와 bottomIdx를 제외한 나머지 숫자중에 max를 구할거임
				switch (bottomIdx) {
				case 0:
					topIdx = 5;
					break;
				case 1:
					topIdx = 3;
					break;
				case 2:
					topIdx = 4;
					break;
				case 3:
					topIdx = 1;
					break;
				case 4:
					topIdx = 2;
					break;
				default:
					topIdx = 0;
					break;
				}
				
				max = searchMax(dice, j, bottomIdx, topIdx);
				sum += max;
				if(j < N-1) {
					bottomIdx = searchTopIdxValue(dice, j, topIdx);
				}
				
			}
			result = Math.max(sum, result);
			sum = 0;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int searchTopIdxValue(int[][] dice, int j, int topIdx) {
		for (int i = 0; i < dice[j+1].length; i++) {
			if(dice[j][topIdx] == dice[j+1][i]) return i;
		}
		return -1;
	}

	private static int searchMax(int[][] dice, int j, int bottomIdx, int topIdx) {
		int max = 0;
		
		for (int i = 0; i < 6; i++) {
			if(i != bottomIdx && i != topIdx) {
				max = Math.max(max, dice[j][i]);
			}
		}
		return max;
	}

}
