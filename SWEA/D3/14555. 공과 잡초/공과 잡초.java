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
		Stack<Character> stack = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			
			String str = br.readLine();
			
			int count = 0;
			for (int j = 1; j <= str.length(); j++) {
				stack.push(str.charAt(j-1));
				if(stack.peek() == '(') {
					count++;
					j += 1;
				}else if(stack.peek() == ')') {
					count++;
				}	
			}
			bw.write("#"+i+" "+count+"\n");
			stack.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
