import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int coin_type = Integer.parseInt(st.nextToken());
		int amount = Integer.parseInt(st.nextToken());
		
		int coin_count = 0;
		for (int j = 0; j < coin_type; j++) {
			stack.push(Integer.parseInt( br.readLine() ));
		}
		
		for (int j = 0; j < coin_type; j++) {
			int temp = stack.pop();
			coin_count += amount/temp;
			
			amount = amount%temp;
		}
		System.out.println(coin_count);
    }
}