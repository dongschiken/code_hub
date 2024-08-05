import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack;
		for (int i = 1; i <= T; i++) {
			
			stack = new Stack<>();
			int N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				int call = Integer.parseInt(br.readLine());
				if(call == 0) stack.pop();
				else stack.push(call);
			}
			
			int sum = 0;
			int size = stack.size();
			for (int j = 0; j < size; j++) {
				sum += stack.pop();
			}
			bw.write("#"+i+" "+sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
