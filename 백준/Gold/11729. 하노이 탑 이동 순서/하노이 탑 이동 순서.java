import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		
		int hanoiCount = Integer.parseInt(br.readLine());
		int start = 1;
		int asst = 2;
		int target = 3;
		count = (int)Math.pow(2, hanoiCount) - 1;
		bw.write(count+"\n");
		hanoi(hanoiCount, start, asst, target );
		
		
		bw.flush();
	}

	private static void hanoi(int hanoiCount, int start, int asst, int target) throws IOException {
		// 시작에서 보조로 모든 원판을 이동시킨 후 
		// 1개가 남으면 그걸 목표 기둥으로 옮긴다.
		
		if( hanoiCount == 1 ) {
			bw.write(start+" "+target+"\n");
			return;
		}
		
		hanoi(hanoiCount-1, start, target, asst);
		
		bw.write(start+" "+target+"\n");
		
		hanoi(hanoiCount-1, asst, start, target);
		
	}

}
