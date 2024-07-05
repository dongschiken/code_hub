

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		int first = 0;
		int max = 0;
		int cur = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if( i == 0 ) {
				first = stack.pop();
				count++;
			}else if( first < (cur = stack.pop()) && max < cur ) {
				max = cur;
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		// 5 6 7 9 7 6 3 2
	}
}
