

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<String> stack = new Stack<String>();
		String trash = br.readLine();
		while (true) {
			String temp = br.readLine();
			if( temp.equals("고무오리 디버깅 끝") ) {
				break;
			} else if(temp.equals("문제")) {
				stack.push(temp);
				continue;
			} else if(temp.equals("고무오리")) {
				if( !stack.isEmpty() ) {
					stack.pop();
				}else {
					stack.push("문제");
					stack.push("문제");
				}
			}
		}
		if( stack.isEmpty() ) {
			bw.write("고무오리야 사랑해");
		}else {
			bw.write("힝구");
		}
		bw.flush();
		bw.close();
	}
}
