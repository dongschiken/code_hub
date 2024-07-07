import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			
			char[] temp = br.readLine().toCharArray();
			int c_length = 0;
			while (c_length < temp.length) {
				stack.push(temp[c_length]);
				if(stack.size() >= 2) {
					char c1 = stack.pop();
					char c2 = stack.pop();
					if(c1 != c2) {
						stack.push(c2);
						stack.push(c1);
					}
				}
				c_length++;
			}
			if(stack.isEmpty()) count++;
			stack.clear();
		}
		bw.write(count+"");
		bw.flush();
	}

}
