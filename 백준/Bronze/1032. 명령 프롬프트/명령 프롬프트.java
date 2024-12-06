import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] chArr = new char[N][];
		for (int i = 0; i < N; i++) {
			chArr[i] = br.readLine().toCharArray();
		}
		
		cont:
		for (int i = 0; i < chArr[0].length; i++) {
			for (int j = 1; j < N; j++) {
				if(chArr[j-1][i] != chArr[j][i]) {
					bw.write("?");
					continue cont;
				}
			}
			bw.write(chArr[0][i]);
		}
		bw.flush();
	}
}
