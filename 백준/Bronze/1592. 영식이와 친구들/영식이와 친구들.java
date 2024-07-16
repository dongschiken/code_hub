import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] friends = new int[N][1];
		friends[0][0] = 1;
		int friend = 0;
		int count = 0;
		while (true) {
			if(friends[friend][0] == M) {
				break;
			}
			if(friends[friend][0] % 2 == 1) {
				friend += L;
				if(friend > N-1) {
					// 7 - 5 -> 1이되는
					friend = friend - N;
				}
				count++;
				friends[friend][0]++;
			}else {
				
				friend -= L;
				if(friend < 0) {
					friend = N + friend;
				}
				count++;
				friends[friend][0]++;
			}
		}
		System.out.println(count);
	}

}
