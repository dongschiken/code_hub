import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		push X: 정수 X를 큐에 넣는 연산이다.
//		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 큐에 들어있는 정수의 개수를 출력한다.
//		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		
//		add할때 시간은 같겠지만 큐,덱의 remove는 O(1)이고 벡터는 O(N)입니다
//		삭제한 자리의 뒤에 있는 모든 원소들의 복사해 앞으로 당기는 작업을 합니다
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		int queue_count = Integer.parseInt(st.nextToken());
		
		
		
		while (queue_count > 0) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push":
				int command = Integer.parseInt(st.nextToken());
				queue.push(command);
				break;
			case "pop":
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(queue.pollLast() + "\n");
				}
				break;	
			case "size":
				size(queue);
				break;
			case "front":
				front(queue);
				break;
			case "back":
				back(queue);
				break;
			case "empty":
				empty(queue);
				break;
			}
			
			queue_count--;
		}
		bw.flush();
		bw.close();
		br.close();
		
		
		

	}

	private static void empty(ArrayDeque<Integer> queue) throws IOException {
		if( queue.isEmpty() ) bw.write(1 + "\n");
		else bw.write(0 + "\n");
	}

	private static void back(ArrayDeque<Integer> queue)  throws IOException{
		if( queue.isEmpty()) {
			bw.write(-1 + "\n");
			return;
		}
		bw.write(queue.peekFirst() + "\n");
		
	}

	private static void front(ArrayDeque<Integer> queue) throws IOException {
		if( queue.isEmpty()) {
			bw.write(-1 + "\n");
			return;
		}
		bw.write(queue.peekLast() + "\n");
		
	}

	private static void size(ArrayDeque<Integer> queue) throws IOException {
		bw.write(queue.size() + "\n");
		
	}

}
