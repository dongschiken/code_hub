
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] num_check;
	static int N;
	static int M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num_check = new int[M];
		
		
		recursion(1, 0);
		
		bw.flush();
		bw.close();
		br.close();
		

	}
	private static void recursion(int x, int index) throws IOException {
		if( index == M ) {
			for (int i = 0; i < num_check.length; i++) {
				bw.write(num_check[i]+1+" ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = x; i <= N; i++) {

			num_check[index] = i-1;
			recursion(i + 1, index+1);

		}
	}

}
