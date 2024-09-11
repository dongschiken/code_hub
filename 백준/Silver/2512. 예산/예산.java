import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		long max = -1;
		int result = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			result += arr[i];
		}
		
		int K = Integer.parseInt(br.readLine());
		long start = 1;
		long end = max;
		long mid = 0;
		long sum = 0;
		while (start <= end) {
			
			mid = (start + end) / 2;
			
			sum = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i] <= mid) {
					sum += arr[i];
				}else {
					sum += mid;
				}
			}
			if(sum <= K) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		// 486
		System.out.println(end);
	}
}