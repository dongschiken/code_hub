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
		int[] arr1;
		int[] arr2;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int result = 0;
			br.readLine();
            // 문자열을 입력받아서 int[]로 만드는 메서드 체이닝
			arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			result = arr1.length > arr2.length ? maxValue(arr1, arr2) : maxValue(arr2, arr1);
			
			bw.write("#"+i+" "+result+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int maxValue(int[] big, int[] small) {
		int result = 0;
		int max = Integer.MIN_VALUE;
        // 만약 big == 4  /  small == 2 ->  4 - 2 + 1 = 3번만큼 반복
		for (int i = 0; i < big.length - small.length + 1; i++) {
			for (int j = 0; j < small.length; j++) {
				result += big[j+i] * small[j];
			}
			max = Math.max(result, max);
			result = 0;
		}
		return max;
	}
}