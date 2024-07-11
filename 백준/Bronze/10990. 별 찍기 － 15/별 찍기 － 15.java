import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// 1 3 5 7 9
		// 1 2 3 4 5
		for (int i = 0; i < N; i++) {
			if( i == 0 ) {
				bw.write(" ".repeat(N-i-1));
				bw.write("*".repeat(1));
				bw.write("\n");
			}else {
				bw.write(" ".repeat(N-i-1));
				bw.write("*".repeat(1));
				bw.write(" ".repeat(i*2-1));
				bw.write("*".repeat(1));
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
