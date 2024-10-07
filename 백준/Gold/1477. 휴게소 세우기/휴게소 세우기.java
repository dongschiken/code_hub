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
	public static void main(String[] args) throws IOException {
		// 그리디 방식으로 반 나누면서 풀었는데 실패..
		// 0 100 400 500 600
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // buildCount
		int L = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();

		// 설치하고(cnt+)
		// 설치 안되면 end = mid - 1;
		// 만약 설치 되면 start = mid + 1;
		if(N != 0)
		st = new StringTokenizer(br.readLine());
		list.add(0);
		for (int i = 1; i <= N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.add(L);
		Collections.sort(list);
		int start = 1;
		int end = L;
		int mid = 0;
		while (start < end) {
			mid = start + end >>> 1;
			int cnt = 0;
			for (int i = 1; i < list.size(); i++) {
				cnt += (list.get(i) - list.get(i - 1) - 1) / mid; 
			}
			if(cnt <= M) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}
}
