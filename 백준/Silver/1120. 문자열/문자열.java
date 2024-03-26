
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		String str2 = st.nextToken();

		int count = 0;
		// 한문자씩 비교하면서 앞에 먼저 더하기 -> 뒤에 더하기
		// 차이가 최소인놈을 뽑기 min값으로 계속 비교
		if( str.length() == str2.length()) {
			for (int i = 0; i < str.length(); i++) {
				if((str.charAt(i) != str2.charAt(i))) {
					count++;
				}
			}
		}else {
			count = compare_solution(str, str2);
		}

		System.out.println(count);

	}
	//abc topabcoder
	private static int compare_solution(String str, String str2) {
		int[] index_arr = new int[str.length()];
		int[] temp_index_arr = new int[str.length()];	
		int max = 0;
		int count = 0;
		// str2는 str의 길이에서 1뺀값까지 비교
		for (int i = 0; i < str2.length()-(str.length()-1); i++) {
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == str2.charAt(j+i)){				
					count++;
				}
				index_arr[j] = j+i;
			}
			max = Math.max(max, count);
			if( max == count ) {
				for (int j = 0; j < temp_index_arr.length; j++) {
					temp_index_arr[j] = index_arr[j];
				}
			}
			count = 0;
		}
		for (int k = 0; k < temp_index_arr.length; k++) {
			if(str.charAt(k) != str2.charAt(0+temp_index_arr[k])){
				count++;
			}	
		}
		return count;
	}
}
