import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for (int j = 1; j <= c; j++) {
				int roomNumber = 100+j;
				for (int j2 = 0; j2 < r; j2++) {
					count++;
					if(count == N) {
						bw.write(roomNumber+"\n");
						break;
					}
					roomNumber += 100;
				}
			}
		}
		bw.flush();
	}
}
