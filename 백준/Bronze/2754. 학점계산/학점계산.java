
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double point = 0.0;
		
		
		String c = br.readLine();
		
		char[] my_point = null;
		if( c.equals("F") ) {
			my_point = new char[]{c.charAt(0)};
		}else {
			my_point = new char[]{c.charAt(0), c.charAt(1)};
		}
		
		
		
		switch (my_point[0]) {
		case 'A':
			point += 4;
			break;
		case 'B':
			point += 3;
			break;
		case 'C':
			point += 2;
			break;
		case 'D':
			point += 1;
			break;
		default:
			break;
		}
		
		if(my_point[0] == 'F') {
			System.out.printf("%.1f", point);
		}else {
			System.out.printf("%.1f", point += my_point[1] == '+' ? 0.3 : (my_point[1]) == '0' ? 0.0 : -0.3);
		}

	}

}
