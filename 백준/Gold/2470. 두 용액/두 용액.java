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
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N - 1;
		int min = Math.abs(arr[start] + arr[end]);
		int[] result = new int[2];
		while (start < end) {
			int sValue = arr[start];
			int eValue = arr[end];
			int sum = sValue + eValue;
			if(min >= Math.abs(sum)) {
				min = Math.abs(sum);
				result[0] = sValue;
				result[1] = eValue;
				if(sum == 0) break;
			}
			if(sum < 0) {
				start++;
			}else if(sum > 0) {
				end--;
			}
		}
		
		bw.write(result[0] +" " + result[1]);
		bw.flush();
		bw.close();
		br.close();
	}

}
