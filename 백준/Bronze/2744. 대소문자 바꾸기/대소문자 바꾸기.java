import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split("");
		for (int i = 0; i < temp.length; i++) {
			if((int)temp[i].charAt(0) <= 90) {
				temp[i] = temp[i].toLowerCase();
			}else {
				temp[i] = temp[i].toUpperCase();
			}
			sb.append(temp[i]);
		}
		System.out.println(sb);
		
		
	}

}
