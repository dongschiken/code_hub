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
		// 1개의 값을 찾으면서 left, right 조정하는 알고리즘 사용하면 2500만번에 끝낼 수 있따.
		// 5000개의 값이 입력된다고 가정하면
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] result = new long[3];
		Arrays.sort(arr);
		int start = 0;
		int end = N - 1;
		long min = Math.abs(arr[start] + arr[end] + arr[1]);
		result[0] = arr[start];
		result[1] = arr[1];
		result[2] = arr[end];
		OUT:
		for (int i = 0; i < N; i++) {
			start = 0;
			end = N - 1;
			while (start < end) {
				if(start == i) start++;
				if(end == i) end--;
				if(end < 0 || start >= N || start >= end) break;
				long sum = arr[start] + arr[end] + arr[i];
				if(min >= Math.abs(sum)) {
					result[0] = arr[start];
					result[1] = arr[i];
					result[2] = arr[end];
					min = Math.abs(sum);
					if(sum == 0) break OUT;
				}
				if(sum > 0) {
					end--;
				}else if(sum < 0) {
					start++;
				}
			}
		}
		Arrays.sort(result);
		System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}

}
