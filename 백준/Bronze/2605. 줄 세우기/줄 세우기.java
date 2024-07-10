import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		5
//		0 1 1 3 2
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0) {
				deque.offer(i);
			}else {
				for (int j = 0; j < temp; j++) {
					deque.offerFirst(deque.pollLast());
				}
				deque.offer(i);
				for (int j = 0; j < temp; j++) {
					deque.offerLast(deque.pollFirst());
				}
			}
		}
		for (int i = 0; i < N; i++) {
			bw.write(deque.poll()+" ");
		}
		bw.flush();
		bw.close();
	}
}
