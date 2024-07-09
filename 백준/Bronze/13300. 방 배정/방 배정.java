import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		double[][][] sCount = new double[7][2][1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1 1
		// 남자 1학년
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			sCount[grade][gender][0]++;
		}
		
		int count = 0;
		for (int i = 1; i < 7; i++) {
			count += Math.ceil(sCount[i][0][0]/M);
			count += Math.ceil(sCount[i][1][0]/M);
		}
		System.out.println(count);
	}

}
