import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int std_count = Integer.parseInt(br.readLine());
		String[] temp = new String[4];
		StringTokenizer st = null;
		String[] std_arr = new String[std_count];
		String[] temp_arr = new String[std_count];	
		String str = null;
		int index = 0;
		for (int i = 0; i < std_arr.length; i++) {
			str = new String();
			temp_arr[i] = br.readLine();
			st = new StringTokenizer(temp_arr[i]);
			for (int j = 0; j < 4; j++) {
				temp[j] = st.nextToken();
			}
			if( temp[2].length() == 1) {
				temp[2] = "0"+temp[2];
			}
			if( temp[1].length() == 1) {
				temp[1] = "0"+temp[1];
			}
			str += temp[3] + temp[2] + temp[1] + temp_arr[i];
			std_arr[i] = str;
			
		}
		Arrays.sort(std_arr, Comparator.reverseOrder());
		index = std_arr[0].indexOf(" ");
		System.out.println(std_arr[0].substring(8, index+1));
		index = std_arr[std_arr.length-1].indexOf(" ");
		System.out.println(std_arr[std_arr.length-1].substring(8, index+1));
		

	}

}
