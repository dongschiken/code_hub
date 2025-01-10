import java.util.*;

class Solution {
    
    private static Stack<Character> stack;
    
    public int solution(String s) {
        int answer = 0;
        stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(isCorrect(s)) answer++;
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        return answer;
    }
    public boolean isCorrect(String s) {
        stack.clear();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
            } else if(stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
            } else if(stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));   
            }
        }
        return stack.isEmpty();
    }
}