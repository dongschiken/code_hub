import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 체스판을 자른다. 만약 8 by 8이면 1 1로 변경
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int nr = R-7;
		int nc = C-7;
		String[] chessBoard = new String[R];
		for (int i = 0; i < chessBoard.length; i++) {
			chessBoard[i] = br.readLine();
		}
		int temp = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				temp = checkSolution(i, j, chessBoard);
                min = Math.min(temp, min);
			}
		}
		System.out.println(min);
	}

	private static int checkSolution(int i, int j, String[] chessBoard) {
        // 홀수 번째 줄이 흰색 체스칸이 시작이고, 짝수 번째 줄이 검은 체스칸 시작
		char[][] whiteBoard = {
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
		};
		
		int whiteBoardSum = 0;
		int count;
		for (int k = i; k < 8+i; k++) {
			count = 0;
			for (int k2 = j; k2 < 8+j; k2++) {
                 // 체스판을 8 칸씩 순회하면서 흰색 체스칸이 시작인 배열과 비교
				if(chessBoard[k].charAt(k2) != whiteBoard[k%2][count++]) {
					whiteBoardSum += 1;
				}
			}
		}
        // 만약 흰 체스칸이 시작인 체스판 검사 결과가 나왔을때
        // 64칸 - 흰 체스판을 해주면 검은 체스칸이 시작인 체스판 검사 결과가 나온다.
		return Math.min(64-whiteBoardSum, whiteBoardSum);
	}

}
