import java.util.Stack;

class Solution {
    
    
    boolean solution(String s) {
        boolean answer = true;

      Stack st = new Stack();
        int length = s.length();
        for (int i = 0; i <length; i++) {
        	
        	if (s.charAt(i)=='(') {
        		st.push(s.charAt(i));        	
				
			} else if(s.charAt(i)==')'){
				if (st.isEmpty()) {
					
				answer = false;	
				}
							
				if (!st.empty()) {
					
					st.pop();				
				}
				
			}

		}//for
        System.out.println(st);
        if (!st.isEmpty()) {
			answer = false;
		}

        return answer;
    }
}