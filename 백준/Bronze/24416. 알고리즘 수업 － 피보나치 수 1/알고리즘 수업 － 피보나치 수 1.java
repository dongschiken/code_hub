import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		long recursive = recursion(n);
		bw.write(recursive+"\n");
		bw.write((n-2)+"");
		bw.flush();

	}

	private static int recursion(int n) {
		if(n == 1 || n == 2) return 1;
		return recursion(n-2) + recursion(n-1);	
	}

}
