import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int[] result = new int[13];
			int[] price = new int[4];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < price.length; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 13; j++) {
				int day = Integer.parseInt(st.nextToken());
				result[j] = Math.min(result[j - 1] + price[0] * day , result[j - 1] + price[1]);
				if( j >= 3 ) result[j] = Math.min(result[j], result[j - 3] + price[2]);
			}
			result[12] = Math.min(price[3], result[12]);
			bw.write("#"+i+" "+result[12]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
