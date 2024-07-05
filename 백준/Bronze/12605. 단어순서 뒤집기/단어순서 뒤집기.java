import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<String> stack = new Stack<String>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				stack.push(temp[j]);
			}
			int size = stack.size();
			bw.write("Case #"+(i+1)+": ");
			for (int j = 0; j < size; j++) {
				bw.write(stack.pop());
				bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
