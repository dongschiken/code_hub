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
		
		int[] arr = new int[12];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 1; j <= 3; j++) {
				arr[i+4] += arr[j+i];
			}
		}
		
		for (int i = 0; i < testcase; i++) {
			int temp = Integer.parseInt(br.readLine());
			bw.write(arr[temp]+"\n");
		}
        bw.flush();
        bw.close();
        br.close();
	}

}
