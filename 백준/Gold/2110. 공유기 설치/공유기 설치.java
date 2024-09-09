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
		
		Arrays.sort(arr);
		long start = 1;
		long end = max;
		
		while (start <= end) {
			
			long mid = (start + end) / 2;
			
			int cnt = 1;
			long cur = arr[0];
			for (int i = 1; i < N; i++) {
				if(arr[i] > cur + mid) {
					cnt++;
					cur = arr[i];
				}
			}
			if(cnt < K) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(start);
		
	}
}
