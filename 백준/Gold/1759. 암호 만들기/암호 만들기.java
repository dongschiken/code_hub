import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<String> list = new ArrayList<>();
	static List<Character> chList = new ArrayList<>();
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 4개인상황에서 StringBuilder에 담아야하나??
		// 한개의 모음, 두개의 자음이 포함된 상태에서 N개라면 리스트에 담기

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			chList.add(st.nextToken().charAt(0));
		}
		Collections.sort(chList);
		dfs(0, 0);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	static List<Character> temp = new ArrayList<>();
	private static void dfs(int loop, int stage) {
		if(stage == N) {
			// 모음이 1개이상, 자음이 2개이상 포함된 상태라면
			int cnt = 0;
			String str = "";
			for (int i = 0; i < temp.size(); i++) {
				str += temp.get(i);
				// 모음이 N - 1개 이상이면 로직 불가능
				char ch = temp.get(i);
				if(ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u') cnt++;
			}
			if(cnt >= N - 1) {
				return;
			}else if(cnt >= 1 && cnt < N -1){
				list.add(str);
			}
		}

		for (int i = loop; i < M; i++) {
			temp.add(chList.get(i));
			dfs(i + 1, stage + 1); 
			temp.remove(temp.size() - 1);
		}
	}
}
