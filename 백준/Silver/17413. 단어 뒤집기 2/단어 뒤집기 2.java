
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder text = new StringBuilder();
		StringBuilder reverse_str = new StringBuilder();
		String s = br.readLine();
		int s_length = s.length();
		int count = 0;
		
		while (s_length > count) {
			if( s.charAt(count) == '<') {
				text.append(reverse_str.reverse());
				reverse_str.delete(0, reverse_str.length()+1);
				while (s.charAt(count) != '>') {
					text.append(s.charAt(count));
					count++;
				}
				text.append(s.charAt(count));
				
			}else if( s.charAt(count) == ' '){
				text.append(reverse_str.reverse().append(' '));
				reverse_str.delete(0, reverse_str.length()+1);
			}else {
				reverse_str.append(s.charAt(count));
			}
			
			count++;
		}
		text.append(reverse_str.reverse());
		System.out.println(text);
		
//		
	}

}
