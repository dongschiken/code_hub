import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

    public class Solution {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static List<int[]> high = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;
    static int N, K, maxValue;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            high.clear();  
            maxValue = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        high.add(new int[] {i, j});
                    }
                }
            }

            for (int k = 1; k <= K; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                    	int tmp = map[i][j];
                        map[i][j] -= k;
                        for(int j2 = 0; j2 < high.size(); j2++) {
                        	visited = new boolean[N][N];
                        	dfs(high.get(j2)[0], high.get(j2)[1], 1);
                        }
                        map[i][j] = tmp;
                    }
                }
            }

            bw.write("#" + t + " " + maxValue + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int r, int c, int value) {
		visited[r][c] = true;
		
    	for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				maxValue = Math.max(value + 1, maxValue);
				dfs(nr, nc, value + 1);
				visited[nr][nc] = false;
			}
		}
	}

	private static boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
}
