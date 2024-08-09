import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int[] temp = new int[1000001];
			int cnt = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = j+1; j2 < arr.length; j2++) {
					temp[cnt++] = arr[j] * arr[j2]; 
				}
			}
			Arrays.sort(temp);
			int max = 0;
			OUT:
			for (int j = temp.length-1; j >= temp.length-cnt ; j--) {
				String str = String.valueOf(temp[j]);
				int cur = str.charAt(0);
				for (int k = 1; k < str.length(); k++) {
					if(cur > str.charAt(k)) {
						continue OUT;
					}else {
						cur = str.charAt(k);
					}
				}
				max = Math.max(temp[j], max);
			}
			if(max == 0 || max < 10) {
				bw.write("#"+i+" -1\n");
			}else {
				bw.write("#"+i+" "+max+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}