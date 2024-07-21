import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		String str = "";
		while (!(str = br.readLine()).equals("END")) {
			sb.append(str);
			bw.write(sb.reverse()+"\n");
			sb.delete(0, sb.length());
		}
		bw.flush();
		bw.close();
		
	}
}
