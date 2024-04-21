
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpa = new int[26];
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			alpa[(int)word.charAt(i)-97]++;
		}
		for (int c : alpa) {
			System.out.printf("%d ", c);
		}
	}

}
