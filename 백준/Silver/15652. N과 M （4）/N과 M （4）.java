import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		dfs(0, 0);
	}

	private static void dfs(int loop, int stage) {
		
		if(stage == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + 1 + " ");
			}
			System.out.println();
			return;
		}
		
		for (int j2 = loop; j2 < N; j2++) {
			arr[stage] = j2;
			dfs(j2, stage + 1);
		}	
	}
}
