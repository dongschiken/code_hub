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
			int c_length = 1;
			stack.push(temp[0]);
			while (c_length < temp.length) {
				if( stack.isEmpty() || stack.peek() != temp[c_length]) {
					stack.push(temp[c_length]);
				}else {
					stack.pop();
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
