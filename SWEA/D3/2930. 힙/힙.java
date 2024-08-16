import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		PriorityQueue<Integer> pq;
		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			pq = new PriorityQueue<>(Collections.reverseOrder());
			
			System.out.print("#"+i+" ");
			for (int j = 0; j < N; j++) {

				int command = sc.nextInt();

				switch (command) {
				case 1:
					pq.add(sc.nextInt());
					break;
				default:
					if(!pq.isEmpty()) System.out.print(pq.poll()+" ");
					else System.out.print(-1+" ");
					break;
				}
			}
			System.out.println();
		}
	}
}
