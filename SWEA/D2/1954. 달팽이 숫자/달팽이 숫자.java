
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] snail = new int[N*N+1];
			
			// 시작점 4개를 만들고 배열로 관리
							 //  아래 왼쪽  위      오른쪽
			int[] dc = new int[] {N, N*N, N*(N-1)+1, N+1};
			int number = 0;
			for (int j = 0; j < N; j++) {
				snail[++number] = j+1;
			}
			// 3 => 6번
			// 4 => 12번
			// 5 => 20번
			// N*N - N;
			int loop = N*N-N;
			int count = 0;
			int Individual = N-1;
			int j = N+1;
			while (Individual > 0) {
				
				if(count == 2) {
					Individual--;
					count = 0;
				}
				if(number == dc[0]) {
					for (int j2 = 0; j2 < Individual; j2++, j++) {
						number += N;
						snail[number] = j;
					}
					dc[0] += (N-1);
				}else if(number == dc[1]) {
					for (int j2 = 0; j2 < Individual; j2++, j++) {
						number -= 1;
						snail[number] = j;
					}
					dc[1] -= (N+1);
				}else if(number == dc[2]) {
					for (int j2 = 0; j2 < Individual; j2++, j++) {
						number -= N;
						snail[number] = j;
					}
					dc[2] -= (N-1);
				}else if(number == dc[3]) {
					for (int j2 = 0; j2 < Individual; j2++, j++) {
						number += 1;
						snail[number] = j;
					}
					dc[3] += (N+1);
				}
				count++;
			}
			bw.write("#"+(i+1)+"\n");
			for (int j2 = 1; j2 <= N*N; j2++) {
				bw.write(snail[j2]+" ");
				if(j2 % N == 0) {
					bw.write("\n");
				}
			}
		}
		bw.flush();
		bw.close();
		
	}
}
