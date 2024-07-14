import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		int seven_dwarf = 0;
		OUT :
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				seven_dwarf = sum - (arr[i] + arr[j]);
				if(seven_dwarf == 100) {
					arr[i] = arr[j] = 0;
					break OUT;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if(arr[i] != 0) {
				bw.write(arr[i]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
