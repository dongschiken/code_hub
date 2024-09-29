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
		int[] price;
		int[] result;
		int[] month;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			result = new int[13];
			price = new int[4];
			for (int j = 0; j < 4; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 13; j++) {
				int cost = Integer.parseInt(st.nextToken());
				result[j] = Math.min(result[j - 1] + cost * price[0], result[j - 1] + price[1]);
				if(j >= 3) result[j] = Math.min(result[j], result[j - 3] + price[2]);
			}
			bw.write("#"+i+" "+Math.min(result[12], price[3])+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
