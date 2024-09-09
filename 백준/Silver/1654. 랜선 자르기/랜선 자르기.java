import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long result = 0;
		long[] arr = new long[N];
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long start = 1;
		long end = max;

		// 최적의 길이를 찾아야한다.
		while (start <= end) {

			long mid = (start + end) / 2;

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}
			if (cnt < K) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
	}
}
