import java.util.*;
class Solution {
    boolean solution(String s) {
       
		boolean answer = true;
		Stack stack = new Stack();

		if(s.charAt(0) == ')'){
			return  answer = false;
		}
		stack.push(s.charAt(0));
		char c = ' ';
		int count = 1;
		while(count <= s.length()-1){
			if( stack.isEmpty()) {
				stack.push(s.charAt(count));
				count++;
				continue;
			}
			c = (char)stack.pop();
			if(c == '('){
				if( s.charAt(count) == ')') {
					count++;
					continue;
				}else {
					stack.push(c);
					stack.push(s.charAt(count));
				}
					
				
			}else {
				stack.push(c);
				stack.push(s.charAt(count));
			}
			count++;
		}
		if( stack.isEmpty()) {
			return answer = true;
		}else {
			return answer = false; 
		}
  }
}