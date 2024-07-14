import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			// 성별 받은 수
			// 1남자 2여자
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			int temp = number;
			if(gender == 1) {
				while (number < N+1) {
					// 전구가 1일때
					if(arr[number] == 1) {
						arr[number] = 0;
					}else {
						arr[number] = 1;
					}
					number += temp;
				}
			}else {
				// +1 -1하면서 계속 전진 언제까지?? 끝이 날때까지
				int left = number;
				int right = number;
				while (left > 1 && right < N) {
					if(arr[left-1] == arr[right+1]) {
						left = left-1;
						right = right+1;
					}else {
						break;
					}
				}
				for (int j = left; j <= right; j++) {
					if(arr[j] == 0) {
						arr[j] = 1;
					}else {
						arr[j] = 0;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			bw.write(arr[i]+" ");
			if(i % 20 == 0) {
				bw.write("\n");
			}
		}
		bw.flush();
	}
}
