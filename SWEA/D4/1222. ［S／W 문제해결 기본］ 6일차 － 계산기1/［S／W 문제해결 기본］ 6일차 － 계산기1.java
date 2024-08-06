import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int leng = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int sum = 0;
			for (int k = 0; k < leng; k++) {
				if(str.charAt(k) >= 48 && str.charAt(k) <= 57) {
					sum += str.charAt(k)-48;
				}
			}
			System.out.println("#"+i+" "+sum+"\n");
		}
	}	
}
