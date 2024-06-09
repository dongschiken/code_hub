import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int testcase = Integer.parseInt(br.readLine());
		int[] queuestack = new int[testcase];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < queuestack.length; i++) {
			queuestack[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < testcase; i++) {
			if( queuestack[i] == 0 ) {
				deque.offer(Integer.parseInt(st2.nextToken()));
			}else {
				st2.nextToken();
			}
		}
		int seq_length = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < seq_length; i++) {
			int cur = Integer.parseInt(st.nextToken());
			
			deque.offerFirst(cur);
			bw.write(deque.pollLast()+" ");
		}	
		bw.flush();
	}

}
