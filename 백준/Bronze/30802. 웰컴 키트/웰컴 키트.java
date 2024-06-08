import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
//		23
//		3 1 4 1 5 9
//		5 7
		int participant_count = Integer.parseInt(br.readLine());
		int t_count = 0;
		int p_div = 0;
		int p_mod = 0;
		ArrayList<Integer> participant = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			participant.add(Integer.parseInt(st.nextToken()));
		}
		
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 6; i++) {
			int cur = participant.remove(0);
			t_count += (int) (cur + t - 1) / t;
		}
		bw.write(t_count+"\n");
		p_div = participant_count/p;
		bw.write(p_div+" ");
		p_mod = participant_count%p;
		bw.write(p_mod+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
