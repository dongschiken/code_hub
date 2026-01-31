import java.io.*;
import java.util.*;

public class Main {

    public static class Pair {
        int value, index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new Pair(arr[i], i));
            } else {
                while(!stack.isEmpty()) {
                    int top = stack.peek().value;
                    int index = stack.peek().index;
                    if(top <= arr[i]) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            sb.append(0).append(" ");
                            stack.push(new Pair(arr[i], i));
                            break;
                        }
                    } else {
                        sb.append(index + 1).append(" ");
                        stack.push(new Pair(arr[i], i));
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}