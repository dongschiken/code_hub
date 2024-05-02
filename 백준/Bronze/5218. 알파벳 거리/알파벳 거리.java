import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
    //
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		String[] str = new String[2];
		int temp = 0;
		
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str[0] = st.nextToken();
			str[1] = st.nextToken();
			
			temp = str[0].length();
			int j = 0;
			bw.write("Distances: ");
			while (temp > j) {
				if( str[0].charAt(j) <= str[1].charAt(j))
				bw.write(Math.abs(str[0].charAt(j) - str[1].charAt(j))+" ");
				else {
					int x = (int)str[0].charAt(j);
					int y = (int)str[1].charAt(j);
					x = 91 - x;
					y = Math.abs(65 - y);
					bw.write((x+y)+" ");
				}
				j++;
			}
			bw.write("\n");
		}
		bw.flush();

	}

}
