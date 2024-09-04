import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static int[] parents;
	static Set<Integer> set;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st  = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new HashSet<>();
			parents = new int[N + 1];
			makeSet();
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			}
			
//			System.out.println(Arrays.toString(parents));
			for (int j = 1; j <= N; j++) {
				set.add(find(parents[j]));
			}
			bw.write("#"+i+" "+set.size()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
