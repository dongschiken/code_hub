import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[M + 1];
		
		Arrays.fill(arr, false);
		
		// 제곱근을 사용해도 에라토스테네스의 체를 구할 수 있따.
		for (int i = 2; i <= Math.sqrt(M); i++) {
			for (int j = i + i; j <= M; j += i) {
				if(arr[i]) break;
				if(j % i == 0) arr[j] = true;
			}
		}
		
		for (int i = N; i <= M; i++) {
			if(arr[i]) continue;
			boolean check = isPalindrome(i);
			if(check) sb.append(i).append("\n"); 
		}
		
		sb.append(-1);
		System.out.println(sb);
	}
	
	// 팰린드롬 판별
	static public boolean isPalindrome(int val) {
		int n = val;
		int rev = 0;
		while (n > 0) {
			// n에서 1의 자릿수(나머지연산)를 가져온다
			// n에서 하나 떼온 숫자를 가져와서 rev의 뒤에 붙인다.
			rev = rev * 10 + n % 10;
			
			// n의 1의자릿수를 제거
			n = n / 10;
		}
		return (val == rev);
	}
}
