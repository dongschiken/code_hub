import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<String> hs = new HashSet<String>();
		int count = 0;
		String S = br.readLine();
		int str_length =  S.length();
		

			for (int i = 0; i < str_length; i++) {
				for (int j = i; j < str_length; j+= 1) {
					 hs.add(S.substring(j-i, j+1));
				}
			}
			System.out.println(hs.size());

	}

}
