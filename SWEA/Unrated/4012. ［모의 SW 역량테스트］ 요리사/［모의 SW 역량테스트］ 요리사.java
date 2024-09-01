import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	static int T, N;
	static int min;
	static int[][] foods;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			foods = new int[N][N];
			check = new boolean[N];
			for (int j = 0; j < N; j++) {
				foods[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			min = Integer.MAX_VALUE;
			dfs(0, 0);
			bw.write("#"+i+" "+min+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static private void dfs(int start, int stage) {
		if(stage == N / 2) {
//			if(!check[0]) return; 
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if(check[i] != check[j]) continue;
					if(check[i]) sum1 += foods[i][j] + foods[j][i]; // 2개의 재료가 true
					else sum2 += foods[i][j] + foods[j][i];			// 2개의 재료가 false
				}
			}
			min = Math.min(min, Math.abs(sum1 - sum2));
			return;
		}
	
		for (int i = start; i < N; i++) {
			check[i] = true;
			dfs(i + 1, stage + 1);
			check[i] = false;
		}
	}
}
