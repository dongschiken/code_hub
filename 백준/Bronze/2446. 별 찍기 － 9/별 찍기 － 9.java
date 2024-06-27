import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int star = n*2-1;
		
		for (int i = 0; i < star; i++) {
			if( i < n ) {
				bw.write(" ".repeat(i));
				bw.write("*".repeat(star-(i*2))+"\n");
			}else {
				// i == 5
				bw.write(" ".repeat(star-i-1));
				bw.write("*".repeat(((i*2)-star)+2)+"\n");				
			}
		}
		bw.flush();
	}

}
