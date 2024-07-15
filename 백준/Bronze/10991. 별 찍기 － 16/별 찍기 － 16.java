import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			bw.write(" ".repeat(N-i));
			bw.write("*");
			for (int j = 1; j < i; j++) {
				bw.write(" ");
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
	}

}
