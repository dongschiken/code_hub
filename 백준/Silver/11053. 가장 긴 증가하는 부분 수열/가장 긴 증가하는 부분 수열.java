import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int max = -1;
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(arr[i] > arr[j]) 
					dp[i] = Math.max(dp[i], dp[j] + 1);
				
			}
		}
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
