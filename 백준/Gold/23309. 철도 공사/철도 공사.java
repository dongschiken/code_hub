import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] values = br.readLine().split(" ");
		int[] nexts = new int[1000001];
		int[] prevs = new int[1000001];
		// 초기 역 정보 저장
		for(int i = 1; i < N; i++) {
			int curr = Integer.parseInt(values[i]);
			int prev = Integer.parseInt(values[i - 1]);	
			nexts[prev] = curr;
			prevs[curr] = prev;
		}
		
		nexts[Integer.parseInt(values[N-1])] = Integer.parseInt(values[0]); 
		prevs[Integer.parseInt(values[0])] = Integer.parseInt(values[N-1]); 
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command= st.nextToken();
			int station = Integer.parseInt(st.nextToken());
			if(command.equals("BN")) {
				int nextStation = nexts[station];
				int newStation = Integer.parseInt(st.nextToken());
				sb.append(nextStation).append("\n");
				nexts[station] = newStation;
				nexts[newStation] = nextStation;
				prevs[nextStation] = newStation;
				prevs[newStation] = station;
			} else if(command.equals("BP")) {
				int prevStation = prevs[station];
				int newStation = Integer.parseInt(st.nextToken());
				sb.append(prevStation).append("\n");
				nexts[prevStation] = newStation;
				nexts[newStation] = station;
				prevs[newStation] = prevStation;
				prevs[station] = newStation;
			} else if(command.equals("CN")) {
				int nextStation = nexts[station];
				int nextNextStation = nexts[nextStation];
				sb.append(nextStation).append("\n");
				nexts[nextStation] = 0;
				prevs[nextStation] = 0;
				nexts[station] = nextNextStation;
				prevs[nextNextStation] = station;
			} else { // CP
				int prevStation = prevs[station];
				int prevPrevStation = prevs[prevStation];
				sb.append(prevStation).append("\n");
				nexts[prevStation] = 0;
				prevs[prevStation] = 0;
				nexts[prevPrevStation] = station;
				prevs[station] = prevPrevStation;
			}	
		}
		System.out.println(sb);
	}
}