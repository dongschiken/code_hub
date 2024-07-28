import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
//		1. 파스칼의 삼각형
//	        1
//	       1 1
//	      1 2 1
//	     1 3 3 1
//	    1 4 6 4 1
		int n = sc.nextInt();
		int c = sc.nextInt();
		int p = 2;
		int[][] arr = new int[n][n+1];
		arr[0][1] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n+1; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= i+1; j++) {
				if(i == n-1 && j == c) {
					bw.write(arr[i][j]+"");
				}
			}
			p = 2;
		}
		bw.flush();
	}
	
}