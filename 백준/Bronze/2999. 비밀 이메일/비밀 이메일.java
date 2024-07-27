import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String message = br.readLine();
		int r = 1;
		int c = message.length();
		List<Integer> list = new ArrayList<>();
		// 우리가 어려운게 6, 12

		for (int i = 2; i < c; i++) {
			if(c%i == 0) {
				list.add(i);
			}
		}

		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(list.get(i)*list.get(j) == c && list.get(i) >= list.get(j)) {
					r = list.get(j);
					c = list.get(i);
				}
			}
		}
		if(message.length() == 2) c = 1;
		char[][] email = new char[r][c];
		int count = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				email[j][i] = message.charAt(count++);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				bw.write(email[i][j]);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
