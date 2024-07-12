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

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// Initial sum of the first K elements
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		int max = sum;

		// Sliding window: subtract the element that's left and add the new element
		for (int i = K; i < N; i++) {
			sum += arr[i] - arr[i - K];
			if (sum > max) {
				max = sum;
			}
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
}
