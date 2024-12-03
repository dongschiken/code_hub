import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] prime = new boolean[10000];
	static int[] addNums = { 1, 10, 100, 1000 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false; // 0과 1은 소수가 아님
		for (int i = 2; i < prime.length; i++) {
			if (!prime[i])
				continue; // 소수가 아니면 건너뜀
			for (int j = i + i; j < prime.length; j += i) {
				prime[j] = false; // 소수의 배수를 제거
			}
		}
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			if (s == e) {
				sb.append(0).append("\n");
			} else {
				if (!bfs(s, 0, e)) {
					sb.append("Impossible\n");
				}
			}
		}
		System.out.print(sb);
	}

	private static boolean bfs(int s, int i, int e) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[10000];
		q.offer(new int[] { s, i });
		visited[s] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int primeNum = temp[0];
			int stage = temp[1];
			if (primeNum == e) {
				sb.append(stage + "\n");
				return true;
			}

			for (int j = 0; j < 4; j++) {
				char[] nums = String.valueOf(primeNum).toCharArray();
				char num = nums[j];
				for (char j2 = '0'; j2 <= '9'; j2++) {
					nums[j] = j2;
					int newPrimeNum = Integer.parseInt(String.valueOf(nums));
					if(newPrimeNum < 10000 && newPrimeNum >= 1000 && !visited[newPrimeNum] && prime[newPrimeNum]) {
						q.offer(new int[] {newPrimeNum, stage+1});
						visited[newPrimeNum] = true;
					}
				}
				nums[j] = num;
			}
		}
		return false;
	}
}
