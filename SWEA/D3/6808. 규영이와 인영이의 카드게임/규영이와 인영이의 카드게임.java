import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] gyou = new int[9];
	static int[] in = new int[9];
	static int gPoint = 0;
	static int iPoint = 0;
	static int lose;
	static int win;
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				gyou[j] = Integer.parseInt(st.nextToken()); 
			}
			
			iPoint = 0;
			gPoint = 0;
			int cnt = 0;
			win = 0;
			lose = 0;
			boolean check;
			for (int j = 0; j < 18; j++) {
				check = true;
				for (int k2 = 0; k2 < 9; k2++) {
					if(gyou[k2] == j + 1) {
						check = false;
						break;
					}
				}
				if(check) in[cnt++] = j + 1;
			}
			dfs(0, 0);
			bw.write("#"+i+" "+win +" "+ lose+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	
	private static void dfs(int idx, int stage) {
		if(stage == 9) {
			if(gPoint > iPoint) {
				win++;
			}else if(gPoint < iPoint) {
				lose++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			// 점수 비교해서 합산
			visited[i] = true;
			if(gyou[stage] > in[i]) {
				gPoint += gyou[stage] + in[i];
			}else {
				iPoint += gyou[stage] + in[i];
			}
			dfs(idx + 1, stage + 1);
			visited[i] = false;
			if(gyou[stage] > in[i]) {
				gPoint -= gyou[stage] + in[i];
			}else {
				iPoint -= gyou[stage] + in[i];
			}
		}
	}
}
