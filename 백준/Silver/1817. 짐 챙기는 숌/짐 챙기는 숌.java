import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException , NumberFormatException {
		
//		5 100
//		51 51 51 51 51
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int book_count = Integer.parseInt(st.nextToken());
		int box_weight = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new ArrayDeque();
		
		if( book_count == 0 ) {
			System.out.println(0);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < book_count; i++) {
			deque.offer(Integer.parseInt(st.nextToken()));
		}
		
		int temp = 0;
		int box_count = 0;
		while (!deque.isEmpty()) {
			int cur = deque.poll();
			
			temp += cur;
			
			if( temp > box_weight ) {
				box_count++;
				deque.offerFirst(cur);
				temp = 0;
			}else if( temp == box_weight ) {
				box_count++;
				temp = 0;
			}
			if(deque.isEmpty()) {
				if( temp != 0 ) {
					box_count++;
				}
			}
		}
		System.out.println(box_count);
	}

}
