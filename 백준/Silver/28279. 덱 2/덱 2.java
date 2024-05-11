import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException, NumberFormatException{

		int testcase = Integer.parseInt(br.readLine());
		int num = 0;
		while (testcase > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 1:
				num = Integer.parseInt(st.nextToken());
				offer(command, num);
				break;
			case 2:
				num = Integer.parseInt(st.nextToken());
				offer(command, num);
				break;
			case 3:
				poll(command);
				break;	
			case 4:
				poll(command);
				break;
			case 5:
				bw.write(deque.size()+"\n");
				break;
			case 6:
				isEmpty();
				break;
			case 7:
				peek(command);
				break;	
			default:
				peek(command);
				break;
			}
			testcase--;
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}

	private static void peek(int command) throws IOException {
		if(!deque.isEmpty()) {
			if(command == 7) {
				bw.write(deque.peekFirst()+"\n");
			}else {
				bw.write(deque.peekLast()+"\n");	
			}
		}else {
			bw.write(-1+"\n");
		}
		
		
	}

	private static void isEmpty() throws IOException {
		if(deque.isEmpty()) {
			bw.write(1+"\n");
		}else {
			bw.write(0+"\n");
		}
		
	}

	private static void poll(int command) throws IOException {
		// command가 3, 4일경우 
		if(!deque.isEmpty()) {
			if(command == 3) {
				bw.write(deque.pollFirst()+"\n");
			}else {
				bw.write(deque.pollLast()+"\n");
			}
		}else {
			bw.write(-1+"\n");
		}
		
	}

	private static void offer(int command, int num) {
		// command가 1, 2일경우
		if(command == 1) {
			deque.offerFirst(num);
		}else {
			deque.offerLast(num);
		}
	}

}
