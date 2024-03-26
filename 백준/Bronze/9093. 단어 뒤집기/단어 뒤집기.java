import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb_temp = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		
		while (count > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				sb_temp.append(st.nextToken());
				sb_temp.reverse();
				sb.append(sb_temp+" ");
				sb_temp.delete(0, sb_temp.length()+1);
			}
			
			System.out.println(sb);
			sb.delete(0, sb.length()+1);
			count--;
		}
		
		
		
	}

}
