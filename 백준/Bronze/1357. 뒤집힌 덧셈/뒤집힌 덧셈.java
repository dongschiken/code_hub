import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder x = new StringBuilder();
		StringBuilder y = new StringBuilder();
		
		x.append(st.nextToken());
		y.append(st.nextToken());
		
		
		x = x.reverse();
		y = y.reverse();
		
		String tempx = x.toString();
		String tempy = y.toString();
		
		
		
		int X = Integer.parseInt(tempx);
		int Y = Integer.parseInt(tempy);
		
		int Z = X + Y;
		
		StringBuilder sb = new StringBuilder();
		sb.append(Z);
		sb = sb.reverse();
		
		tempx = sb.toString();
		System.out.println(Integer.parseInt(tempx));
	}

}
