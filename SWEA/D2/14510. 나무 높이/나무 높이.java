import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, max;
	static int[] arr;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			sum = 0;
			max = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[j]);
			}

			solution();
			bw.write("#"+i+" "+sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void solution() {
		Queue<Integer> even = new ArrayDeque<>();
		Queue<Integer> odd = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			if (arr[i] == max)
				continue;

			int tmp = max - arr[i];
			for (int j = 0; j < tmp / 2; j++) {
				even.add(1);
			}
			if (tmp % 2 == 1)
				odd.add(1);
		}

		if (even.size() >= odd.size()) {

			while (true) {
				if (even.size() <= odd.size()) {
					sum += even.size() + odd.size();
					break;
				}
				even.poll();
				odd.add(1);
				odd.add(1);
			}
		} else {
			sum += even.size() * 2;
			int tmp = odd.size() - even.size();
			sum += tmp + (tmp - 1);
		}
	}
}
