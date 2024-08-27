import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		recursive(0, 0);
		System.out.println(sb);
	}

	private static void recursive(int loop, int stage) {
		if(stage == M) {
			for (int i = 0; i < M; i++) {
				sb.append((arr[i] + 1) + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[stage] = i;
			recursive(i + 1, stage + 1);
		}
	}
}
