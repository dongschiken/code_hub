import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	static Map<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
			map.put('+', 1);
			map.put('-', 1);
			map.put('*', 2);
			map.put('/', 2);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			int T = 10;
			
			for (int i = 1; i <= T; i++) {
				int N = Integer.parseInt(br.readLine());
				String infix = br.readLine();
				String postFix = infixToPostFix(infix);
				int result = postFixCalculate(postFix);
				sb.append("#").append(i).append(" ").append(result).append("\n");
			}
		System.out.println(sb);
	}
	private static String infixToPostFix(String infix) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if('0' <= c && c <= '9') {
				sb.append(c);
			}else if(c == '(') {
				stack.push(c);
			}else if(c == ')') {
				char tmp = stack.pop();
				while (tmp != '(') {
					sb.append(tmp);
					tmp = stack.pop();
				}
			}else {
				// 연산자 우선순위에서 현재 c의 우선순위가 stack에 들어있는 우선순위 보다 작아질 때 까지
				// ( 라면 밑에 연산자가 없다는 뜻이니까 아니어야 하는 조건이 붙는다.
				if(!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					char tmp = stack.pop();
					sb.append(tmp);
				}
				stack.push(c);
			}
		}
		return sb.toString();
	}
	
	private static int postFixCalculate(String postFix) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);
            // 0 ~ 9 사이라면 스택에 담는다
			if('0' <= c && c <= '9') {
				stack.push(c - 48);
			}else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				
                // 현재 연산자에 따라서 계산
                // 계산 결과값을 다시 스택에 담는다.
				switch (c) {
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				}
				stack.push(result);
			}
		}
		return result;
	}
}
