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
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		long start = 1;
		long end = max;
		while (start <= end) {
			
			long mid = (start + end) / 2;
			long length = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i] - mid < 0) continue;
				length += arr[i] - mid;
			}
			if(length < K) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
	}
}
