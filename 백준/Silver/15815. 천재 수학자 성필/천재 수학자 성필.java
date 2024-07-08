import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = 0;
		char[] express = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		// 123*+4+ 일때 숫자는 스택에 넣다가 표현식나오면 숫자 2개빼서 계산하고
		// 계산된 결과값을 다시 스택에 넣는다.
		for (int i = 0; i < express.length; i++) {
			if(express[i] >= '0') {
				stack.push((int)express[i]-'0');
			}else {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				result = 0;
				switch (express[i]) {
				case '+':
					result = temp1 + temp2;
					stack.push(result);
					break;
				case '-':
					result = temp2 - temp1;
					stack.push(result);
					break;
				case '/':
					result = temp2 / temp1;
					stack.push(result);
					break;
				case '*':
					result = temp1 * temp2;
					stack.push(result);
					break;
				}
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
