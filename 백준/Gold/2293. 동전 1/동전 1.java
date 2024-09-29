
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n + 1];
		int[] DP = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		DP[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				DP[j] += DP[j - arr[i]];
			}
		}
		System.out.println(DP[k]);
		
	}
}
