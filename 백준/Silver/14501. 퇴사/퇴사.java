import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][2];		
		for (int i = 1; i <= N; i++) {
			
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		dfs(1);
		System.out.println(max);
		sc.close();
	}
	
	static int max = 0;
	static int result = 0;
	private static void dfs(int day) {
		if(day > N+1) return;
		max = Math.max(result, max);
		if(day == N+1) return;
		
		
		for (int i = day; i < arr.length; i++) {
			result += arr[i][1];
			dfs(i+arr[i][0]);
			result -= arr[i][1];
		}
		
	}
	
}
