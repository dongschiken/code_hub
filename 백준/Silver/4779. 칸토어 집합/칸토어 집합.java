
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ( (input = br.readLine()) != null ) {
			sb = new StringBuilder();
			int temp = Integer.parseInt(input);
			int length = (int)Math.pow(3, temp);
			
			
			for (int i = 0; i < length; i++) {
				sb.append('-');
			}
			
			int start = 0;
			recursion_canto( start , length);
			
			System.out.println(sb);
			
		}
		
	}
	
	private static void recursion_canto(int start, int length) {
		
		if( length <= 1 ) return;
		
		// length를 3등분
		int canto_length = length/3;
		
		// 9~17까지 공백으로 바꿔야해서 공백으로 바꾸는것은 시작점+길이 ~ 길이*2한 값이 되는것이다.
		// 27일 경우 9 9 9 로 3등분 되고 시작이 0+9 ~ 9*2라서 len[9]~len[17]이 공백으로 바뀌는 것이다.
		// 이과정을 계속 반복하면 된다.
		for (int i = start+canto_length; i < start+canto_length*2; i++) {
			sb.setCharAt(i,' ');
			
		}
		

		recursion_canto(start, canto_length);
		recursion_canto(start+canto_length*2, canto_length);
	}

}
