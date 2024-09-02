import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	static int[] arr;
	static Sum[] sum1;
	static Sum[] sum2;
	static int[] temp = new int[2];
	static int N, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sum1 = new Sum[N * N - N];
		sum2 = new Sum[N * N - N];

		dfs(0, 0);
		// sum1과 sum2를 정렬
		Arrays.sort(sum1, new Comparator<Sum>() {
			@Override
			public int compare(Sum o1, Sum o2) {
				return o1.sum - o2.sum;
			}
		});
		Arrays.sort(sum2, new Comparator<Sum>() {
			@Override
			public int compare(Sum o1, Sum o2) {
				return o1.sum - o2.sum;
			}
		});
		
//		for (Sum sum : sum1) {
//			System.out.println(sum);
//		}
//		
//		for (Sum sum : sum2) {
//			System.out.println(sum);
//		}
//		
		// 이진탐색 돌리면서 타겟하는 값을 기준으로 sum클래스 받아와서 right와 max를 비교
		for (int j = 0; j < sum1.length; j++) {
			Sum sum = binarySearch(0, sum2.length, sum1[j].sum);
			if (sum != null) {
				if (sum.right > sum.left) max = Math.max(max, sum.right);
				else max = Math.max(max, sum.left);
			}
		}
		System.out.println(max);
	}

	private static Sum binarySearch(int i, int length, int sum) {

		int left = i;
		int right = length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (sum2[mid].sum == sum)
				return sum2[mid];

			if (sum2[mid].sum < sum) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return null;
	}

	static int cnt1 = 0;
	static int cnt2 = 0;

	private static void dfs(int idx, int stage) {
		if (stage == 2) {
			sum1[cnt1] = new Sum(temp[0], temp[1], temp[0] + temp[1]);
			sum2[cnt1] = new Sum(temp[0], temp[1], Math.abs(temp[0] - temp[1]));
			cnt1++;
			return;
		}
		if(idx == N) return;
		for (int i = 0; i < N; i++) {
			temp[stage] = arr[i];
			dfs(i + 1, stage + 1);
		}
	}
}

class Sum {
	int left;
	int right;
	int sum;

	public Sum(int left, int right, int sum) {
		super();
		this.left = left;
		this.right = right;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Sum [left=" + left + ", right=" + right + ", sum=" + sum + "]";
	}

}
