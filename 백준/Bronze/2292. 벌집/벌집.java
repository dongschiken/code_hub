import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int count = 2;
		// 2 ~ 7 2개    6개
		// 8 ~ 19 3개   12개
		// 20 ~ 37 4개  18개
		
		// 13
		// 3개
		int temp = 1;
		int six = 7;
		if(N == 1) {
			System.out.println(1);
			return;
		}
		while (temp < N) {
			if((six) == temp) {
				six += 6*count;
				count++;
			}
			temp++;
		}
		System.out.println(count);
	}
}
