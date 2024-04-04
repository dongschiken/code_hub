import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int atm_count = Integer.parseInt(br.readLine());
		int[] atm_person = new int[atm_count];
		int[] temp_atm_person = new int[atm_count];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < atm_person.length; i++) {
			atm_person[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(atm_person);
		
		int sum = 0;
		int temp_sum = 0;
		for (int i = 0; i < atm_person.length; i++) {
			sum = sum+atm_person[i];
			temp_atm_person[i] = sum;
			temp_sum += temp_atm_person[i];
		}
		System.out.println(temp_sum);
	}

}
