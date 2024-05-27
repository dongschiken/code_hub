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
		
		int testcase = Integer.parseInt(br.readLine());
		
		long[] arr = new long[101];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for (int i = 6; i < 101; i++) {
			arr[i] = arr[i-5] + arr[i-1];
		}
		
		
		for (int i = 0; i < testcase; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(arr[N]+"\n");
		}
		bw.flush();
			
	}

}
