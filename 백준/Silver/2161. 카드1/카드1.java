import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> queue = new ArrayDeque<Integer>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			queue.offer(i+1);
		}
		//System.out.println(queue);
		while (queue.size() != 1) {
			bw.write(queue.poll()+" ");
			queue.offer(queue.poll());
		}
		bw.write(queue.poll()+"");
		bw.flush();
		bw.close();
	}
}
