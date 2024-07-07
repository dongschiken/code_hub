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
			
			String temp = br.readLine();
			int c_length = 1;
			stack.push(temp.charAt(0));
			while (c_length < temp.length()) {
				char c_temp = temp.charAt(c_length);
				if( stack.isEmpty() || stack.peek() != c_temp) {
					stack.push(temp.charAt(c_length));
				}else {
					stack.pop();
				}
				c_length++;
			}
			if(stack.isEmpty()) count++;
			else stack.clear(); // else를 빼는게 더빠름 왜??
		}
		bw.write(count+"");
		bw.flush();
	}

}
