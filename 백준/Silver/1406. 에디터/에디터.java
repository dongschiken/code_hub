import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		StringTokenizer st;
		String tempStr = br.readLine();
		for(String str : tempStr.split("")) {
			left.offer(str.charAt(0));
		}
		int command = Integer.parseInt(br.readLine());
		for (int i = 0; i < command; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "L":
				if(!left.isEmpty())
					right.offerFirst(left.pollLast());
				break;
			case "D":
				if(!right.isEmpty())
					left.offer(right.pollFirst());
				break;
			case "B":
				if(!left.isEmpty())
					left.pollLast();
				break;
			case "P":
				left.offer(st.nextToken().charAt(0));
				break;
			}
		}
		int lSize = left.size();
		int rSize = right.size();
		for (int i = 0; i < lSize; i++) {
			bw.write(left.pollFirst());
		}
		for (int i = 0; i < rSize; i++) {
			bw.write(right.pollFirst());
		}
		bw.flush();
	}
}
