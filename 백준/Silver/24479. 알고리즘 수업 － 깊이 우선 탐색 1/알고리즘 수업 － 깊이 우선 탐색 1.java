import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static int count = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int visited[] = new int[node+1];
		ArrayList<Integer>[] grape = new ArrayList[node+1];
		int count = 0;
		// 이건 진짜 신기한 구조이다. 어렵다... 
		// 리스트를 배열로 만들어서 그 배열방 한개당 새로운 리스트 생성
		for (int i = 0; i < node+1; i++) {
			grape[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < link; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			grape[l].add(r);
			grape[r].add(l);
		}
		
		// 여기서 먼저 grape안에 들어있는 배열을 정렬해주고
		for (int i = 0; i < node; i++) {
			Collections.sort(grape[i]);
		}
		//System.out.println(Arrays.toString(grape));
		
		// dfs호출하면 링크연결된 노드를 기준으로 dfs를 재귀호출한다.
		dfs(start, visited, grape);
		
		for (int i = 1; i < visited.length; i++) {
			bw.write(visited[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int N, int[] 
			visited, ArrayList<Integer>[] grape) {
		visited[N] = count++;
		
		Iterator<Integer> ir = grape[N].iterator();
		while (ir.hasNext()) {
			Integer next = (Integer) ir.next();
			if(visited[next] == 0) dfs(next, visited, grape);
		}
	}
}
