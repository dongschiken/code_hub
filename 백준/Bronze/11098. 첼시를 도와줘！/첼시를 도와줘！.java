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
		
		
		int testcase = Integer.parseInt(br.readLine());
		while (testcase > 0) {
			
			int n =Integer.parseInt(br.readLine());
			String[] temp = new String[n];
			int[] prices = new int[n];
			String[] players = new String[n];
			for (int i = 0; i < n; i++) {
				temp[i] = br.readLine();
				StringTokenizer st = new StringTokenizer(temp[i]);
				prices[i] = Integer.parseInt(st.nextToken());
				players[i] = st.nextToken();
			}
			Arrays.sort(prices);
			int max = prices[n-1];
			String str = max+"";
			for (int i = 0; i < n; i++) {
				if(temp[i].contains(str)) {
					System.out.println(players[i]);
				}
			}
			testcase--;
		}
		
	}
}