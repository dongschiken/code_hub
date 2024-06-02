import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Calendar c = Calendar.getInstance();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int date = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		
		c.set(2009, month-1, date);

		int temp = c.get(Calendar.DAY_OF_WEEK);
		
		String yoil = null;
		switch (temp) {
		case 1: {
			yoil = "Sunday";
			break;
		}
		case 2: {
			yoil = "Monday";
			break;
		}
		case 3: {
			yoil = "Tuesday";
			break;
		}
		case 4: {
			yoil = "Wednesday";
			break;
		}
		case 5: {
			yoil = "Thursday";
			break;
		}
		case 6: {
			yoil = "Friday";
			break;
		}
		default:
			yoil = "Saturday";
			break;
		}
		
		System.out.println(yoil);
		
	}

}
