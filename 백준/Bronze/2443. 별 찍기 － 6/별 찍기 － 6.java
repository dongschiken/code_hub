import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		// 10 8 6 4 2    -1
		// 9 7 5 3 1
		for (int i = 0; i < n; i++) {
			bw.write(" ".repeat(i));
			bw.write("*".repeat( ((n-i)*2) - 1 ));
			bw.write("\n");
		}
		bw.flush();
		//
		
	}

}
