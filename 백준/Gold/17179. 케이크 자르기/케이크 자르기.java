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
		int T = Integer.parseInt(st.nextToken()); // 케이크 자르는 횟수 ( tc )
		int N = Integer.parseInt(st.nextToken()); // 자를 수 있는 지점
		int L = Integer.parseInt(st.nextToken()); // 케이크 최대 길이
		
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[N] = L;
		// 1000번을 반복하느냐, 배열에 넣어놓고 쓰느냐
		for (int i = 0; i < T; i++) {
			int cut = Integer.parseInt(br.readLine());
			int s = 0;
			int e = L;
			while (s <= e) {
				int mid = s + e >>> 1;
				
				int cnt = 0;
				// 무조건 잘라야하는 지점이 있다.
				int cur = 0;
				for (int j = 0; j < arr.length; j++) {
					if(mid + cur <= arr[j]) {
						cur = arr[j];
						cnt++;
					}
				}
				if(cut >= cnt) {
					e = mid - 1;
				}else {
					s = mid + 1;
				}
			}
			System.out.println(e);
		}
	}
}
