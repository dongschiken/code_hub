import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		int target = Integer.parseInt(br.readLine());
		int change = target;
		// 26 -> 2 + 6 = 8 -> 68 -> 6 + 8 = 14 -> 84
		while (true) {
			String[] temp = String.valueOf(target).split("");
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += Integer.parseInt(temp[i]);
			}
			String[] sumStr = String.valueOf(sum).split("");
			
			String targetStr;
			if( temp.length == 1 ) {
				targetStr = temp[0];
			}else {
				targetStr = temp[1];
			}
			
			if( sumStr.length == 1 ) {
				targetStr += sumStr[0];
			}else {
				targetStr += sumStr[1];
			}
			count++;
			target = Integer.parseInt(targetStr);
			if( target == change ) {
				break;
			}
		}
		bw.write(count+"");
		bw.flush();
	}

}
