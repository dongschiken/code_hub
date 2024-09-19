
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		long max = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		// 정렬된 상태로 비교로직을 구현할꺼라서
		Arrays.sort(arr);
		long start = 1; // 최소거리
		long end = max; // 매개변수에서 이분탐색을 진행하기 위해서 현재 찾을 수 있는 값중에 제일 큰값을 end로 만든다
		
		// 이분탐색 로직
		while (start <= end) {
			
			long mid = (start + end) / 2;
			
			int cnt = 1;
			long cur = arr[0]; 	// 무조건 첫번째 위치는 공유기 설치해야한다.
			// 다음 위치에 현재값을 mid와 더해서 같거나 크면 설치할 수 있음! -> cnt를 늘림
			for (int i = 1; i < N; i++) {
				if(arr[i] >= cur + mid) {
					cnt++;
					cur = arr[i]; // 현재 집을 다음집 위치로 초기화
				}
			}
			// 설치된 개수가 K개보다 작으면 end를 mid쪽으로
			// 설치된 개수가 K개 또는 K개보다 크면 start를 mid쪽으로
			if(cnt < K) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		// 로직 검사 전부 끝내고 오면 start는 항상 최대로 구할 수 있는 수 + 1이 되어 있어서 -1을 해줘야한다.
		System.out.println(end);
		
	}
}
