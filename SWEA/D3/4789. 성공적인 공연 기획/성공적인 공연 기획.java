import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] audience;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			
			audience = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			// 문자열 길이만큼 박수 치게 만들어야한다.
			// 고용할 사람 수
			int employment = 0;
			int count = audience[0];
			for (int j = 1; j < audience.length; j++) {
				if(count >= j) {
					count += audience[j];
				}else {
					employment += Math.abs(count - j);
					count += Math.abs(count - j) + audience[j];
				}
			}
			bw.write("#"+i+" "+employment+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
