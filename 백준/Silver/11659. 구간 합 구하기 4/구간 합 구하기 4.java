import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		// 누적합은 무조건 뒤에서부터 앞으로 누적하고
		// 구간합구할때는 start - 1 - last + 1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int range = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		int temp[] = new int[range];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] range_arr = new int[range+1];
		int sum = 0;
		int range_count = range-1;
		for (int i = 0; i < range; i++) {
			sum += temp[range_count];
			range_arr[range_count] += sum;
			range_count--;
		}
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			bw.write(range_arr[start-1] - range_arr[end] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
