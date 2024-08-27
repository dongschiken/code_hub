import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] arr;
	static int max;
	static int calSum;
	static int sum;
	static int N;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			sum = 0;
			calSum = 0;
			max = Integer.MIN_VALUE;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			
			dfs(0, 0);
			System.out.println("#" + i + " " +max);
		}
		
		
	}

	private static void dfs(int loop, int stage) {
		if(calSum == M) {
			max = Math.max(max, sum);
			return;
		}
		if(calSum > M) return;
		max = Math.max(max, sum);
		
		for (int j2 = loop; j2 < N; j2++) {
			
			sum += arr[j2][0];
			calSum += arr[j2][1];
			dfs(j2 + 1, stage + 1);
			sum -= arr[j2][0];
			calSum -= arr[j2][1];
			
		}
	}
}
