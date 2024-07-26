import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int personCount = Integer.parseInt(br.readLine());
		int[] rollCakes = new int[N+1];
		
		int rollCake = 0;
		int index1 = 0;
		int index2 = 0;
		int max = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < personCount; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int temp = end - start + 1;
			if(max < temp) {
				max = temp;
				index1 = i+1;
			}
			
			
			for (int j = start; j <= end; j++) {
				if(rollCakes[j] == 0) {
					rollCakes[j] = 1;
					rollCake++;
				}
			}
			if(max2 < rollCake) {
				max2 = rollCake;
				index2 = i+1;
			}
			rollCake = 0;
		}
		
		bw.write(index1+"\n"+index2);
		bw.flush();
		bw.close();
		br.close();
	}
}
