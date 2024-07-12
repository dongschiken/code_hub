import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 9
		// 6
		// N - K + 1
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < N - K + 1; i++) {
			for (int j = 0; j < K; j++) {
				temp += arr[j+i];
			}
			max = Math.max(max, temp);
			temp = 0;
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

}
