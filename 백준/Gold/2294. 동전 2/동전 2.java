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
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] result = new int[M + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		Arrays.fill(result, 100_000_000);
		result[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i]; j <= M; j++) {
				result[j] = Math.min(result[j - arr[i]] + 1, result[j]);
			}
		}
		if(result[M] == 100_000_000) result[M] = -1;
		System.out.println(result[M]);
	}
}
