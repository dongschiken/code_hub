import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 1;
		int max = 0;
		int wanted = 0;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int temp = N;
			int before = i;
			int now = temp - i;
			count++;
			while (now >= 0) {
				temp = now;
				now = before - now;
				before = temp;
				count++;
			}
			max = Math.max(max, count);
			if(max == count) {
				wanted = i;
			}
			count = 0;
		}
		if( N == 1 ) {
			bw.write((max)+"\n");
		}else {
			bw.write((max+1)+"\n");
		}
		int temp = N;
		int before = wanted;
		int now = temp - before;
		bw.write(temp+" ");
		bw.write(before+" ");
		while (now >= 0) {
			bw.write(now+" ");
			temp = now;
			now = before - now;
			before = temp;
		}
		bw.flush();
		bw.close();
	}

}
