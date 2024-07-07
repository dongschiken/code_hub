import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<String> stack;
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			stack = new Stack<String>();
			String[] temp = br.readLine().split("");
			int t_length = 0;
			while (t_length < temp.length) {
				stack.push(temp[t_length]);
				//System.out.println(stack);
				if( stack.size() >= 2) {
					String str1 = stack.pop();
					String str2 = stack.pop();
					if(str1.equals(str2)) {
						t_length++;
						continue;
					}else {
						stack.push(str2);
						stack.push(str1);
					}
				}
				t_length++;
			}
			if( stack.isEmpty() ) {
				count++;
			}
		}
		bw.write(count+"");
		bw.flush();
	}
}
