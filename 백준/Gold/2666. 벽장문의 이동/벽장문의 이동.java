import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1시 30분까지만
public class Main {

	static List<Integer> list = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static int sum = 0;
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 처음 열린문 2개
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		dfs(left, right, 0, 0);
		System.out.println(result);
	}
	
	// 최종적으로 min값만 구하면 된다.
	private static void dfs(int left, int right, int stage, int value) {
//		System.out.println("left + stage + list : " + left + ", " + stage + ", " + list.get(stage));
		if(stage == M - 1) {
			// stage가 3이되었을때 왼쪽과 오른쪽의 현재까지의 값을 result와 비교해서 더 작은값으로 초기화
			result = Math.min(result, value + Math.abs(list.get(stage) - left));
			result = Math.min(result, value + Math.abs(list.get(stage) - right));
			return;
		}
		// 왼쪽에 있는 문을 사용하는 경우
		dfs(list.get(stage), right, stage + 1, value + Math.abs(list.get(stage) - left));
  		
		// 오른쪽에 있는 문을 사용하는 경우
		dfs(left, list.get(stage),  stage + 1, value + Math.abs(list.get(stage) - right));
	}
}
