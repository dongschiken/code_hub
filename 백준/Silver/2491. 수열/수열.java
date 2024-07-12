import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 2가지 로직을 통해 가장 긴 수열을 찾는다.
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 증가하는 수열
		int max = 0;
		int count = 1;
		for (int i = 1; i < N; i++) {
			if( arr[i-1] <= arr[i] ) {
				count++;
			}else{
				max = Math.max(max, count);
				count = 1;
			}
		}
		max = Math.max(max, count);
		
		// 감소하는 수열
		count = 1;
		for (int i = 1; i < N; i++) {
			if( arr[i-1] >= arr[i] ) {
				count++;
			}else{
				max = Math.max(max, count);
				count = 1;
			}
		}
		max = Math.max(max, count);
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

}
