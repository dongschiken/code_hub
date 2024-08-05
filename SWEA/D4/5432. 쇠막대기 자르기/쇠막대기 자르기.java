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
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack1 = new Stack<>();
        int pipe = 0;
        for (int i = 1; i <= T; i++) {
            int count = 1;
            String str = br.readLine();
            int sum = 0;
            int temp = 0;
            while (count < str.length()) {
                stack1.push(str.charAt(count-1));
                if(stack1.peek() == '(') {
                    if(str.charAt(count) == ')') {
                        sum += pipe;
                    }else {
                    	pipe += 1;
                    }
                }else if(stack1.peek() == ')') {
                    if(str.charAt(count) == ')') {
                        sum += 1;
                        pipe -= 1 ;
                    }
                }
                count++;
            }
            bw.write("#"+i+" "+(sum+temp)+"\n");
            stack1.clear();
        }
        bw.flush();
    }
}