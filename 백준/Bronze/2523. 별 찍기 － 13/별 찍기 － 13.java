import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int star = N*2-1;
		
		for (int i = 0; i < star; i++) {
			if( i < N ) {
				bw.write("*".repeat(i+1));
			}else {
				bw.write("*".repeat((star-i)));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
