import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = 0, y = 0;
		int start = 0;
		int end = N - 1;
		int min = Math.abs(arr[start] + arr[end]);
		while (start < end) {
			int sum = arr[start] + arr[end];
			if(min >= Math.abs(sum)) {
				x = arr[start];
				y = arr[end];
				min = Math.abs(sum);
				if(sum == 0) break;
			}
			
			if(sum > 0) {
				end--;
			}else if(sum < 0) {
				start++;
			}
		}
		System.out.println(Math.min(x, y) + " " + Math.max(x, y));
	}

}
