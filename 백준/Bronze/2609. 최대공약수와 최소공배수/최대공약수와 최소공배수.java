import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		int max_temp = Math.max(max, min);
		int min_temp = Math.min(max, min);
		max = max_temp;
		min = min_temp;
		int minimal = 0;
		int mod_temp = 0;
		do {
			mod_temp = max%min;
			max = min;
			min = mod_temp;
		} while (mod_temp > 0);
		minimal = max_temp*min_temp/max;
		System.out.println(max);
		System.out.println(minimal);
		
	}

}

