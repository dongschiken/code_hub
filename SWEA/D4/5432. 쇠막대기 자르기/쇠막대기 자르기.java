import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //        2
        //        ()(((()())(())()))(())
        //        (((()(()()))(())()))(()())
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack1;
        Deque<Integer> deque;
        for (int i = 1; i <= T; i++) {
            stack1 = new Stack<>();
            deque = new ArrayDeque<>();
            int count = 1;
            String str = br.readLine();
            int sum = 0;
            int temp = 0;
            // 현재 스택의 peek()값이 ( 일때 )라면 레이저 stack2에서 순회 하면서 막대의 값을 +1씩 늘린다.
            // 현재 스택의 peek()값이 ) 일때 )라면 막대에서 제일 마지막 들어온 값을 pop() -> sum+= pop();
            // 현재 스택의 peek()값이 ( 일때 (라면 막대 하나 추가
            while (count < str.length()) {
                stack1.push(str.charAt(count-1));
                if(stack1.peek() == '(') {
                    if(str.charAt(count) == ')') {
                        sum += deque.size();
                    }else {
                        deque.push(1);
                    }
                }else if(stack1.peek() == ')') {
                    if(str.charAt(count) == ')') {
                        sum += 1;
                        deque.pop();
                    }
                }
                count++;
            }
            bw.write("#"+i+" "+(sum+temp)+"\n");
        }
        bw.flush();
    }
}